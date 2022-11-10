package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorExtraccion {

    private frmExtraccion vista;
    private ExtraccionArreglo modelo;

    public ControladorExtraccion(frmExtraccion vista, ExtraccionArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (vista.txtFechaExtraccion.getText().isEmpty() || vista.txtVolumen.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {

                        Float Volumen = Float.parseFloat(vista.txtVolumen.getText());
                       

                        if (Volumen > 0 ) {
                            ExtraccionSangre c = new ExtraccionSangre(vista.txtFechaExtraccion.getText(),Volumen, 
                                    vista.comboGrupoSang.getSelectedItem().toString(),vista.comboRH.getSelectedItem().toString(),
                                    (Donante)vista.comboDonantes.getSelectedItem());
                            
                            Repositorio.extracciones.agregar(c); //AGREGAR AL REPO
                            
                            //Creamos la unidad de sangre;
                            UnidadSangre u=new UnidadSangre(Volumen,vista.comboGrupoSang.getSelectedItem().toString(),vista.comboRH.getSelectedItem().toString());
                            Almacen.UnidadesSangre.add(u);
                            
                            
                            JOptionPane.showMessageDialog(null, "Extraccion Registrada");
                            actualizarTabla();
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Digite datos validos");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Solo se pueden digitar numeros en Volumen");

                    }

                }
            }
        }
        );
        this.vista.botonRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        this.vista.botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblCitasRepo.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar alguna Extraccion");
                } else {
                    int valor = Integer.parseInt(vista.tblCitasRepo.getValueAt(fila, 0).toString());
                    Repositorio.extracciones.eliminar(valor);
                    actualizarTabla();
                    System.out.println("Cita eliminada");
                    JOptionPane.showMessageDialog(null, "Extraccion eliminada");
                }
            }
        }
        );
    }

    public void actualizarTabla() {
        //lo del jtable
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatos(), this.modelo.getCabecera());
        this.vista.tblCitasRepo.setModel(modelotabla);
    }
    public void limpiarCampos(){
        //fecha talla peso diagnostico tratamiento
        this.vista.txtFechaExtraccion.setText("");
        this.vista.txtVolumen.setText("");
        
        
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);


        //lo del combobox donantes
        DefaultComboBoxModel modeloCboEmpleados = new DefaultComboBoxModel();
        
        for (Donante e : Repositorio.donantes.getDatosCombo()) {
            modeloCboEmpleados.addElement(e);
        }
        //le doy al combo del form el modelo
        this.vista.comboDonantes.setModel(modeloCboEmpleados);

        //lo del jtable
        actualizarTabla();
    }
}
