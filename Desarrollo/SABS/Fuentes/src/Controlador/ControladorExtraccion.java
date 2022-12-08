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
    private ConsultasExtraccion modeloC = new ConsultasExtraccion();
    private ConsultasSangre modeloU = new ConsultasSangre();
    private ConsultasDonante modeloD = new ConsultasDonante();
    private frmExtraccion vista;
    private ExtraccionArreglo modelo;
//a
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
                        //int Volumen = Integer.parseInt(vista.txtVolumen.getText());

                        if (Volumen > 0 ) {
                            ExtraccionSangre c = new ExtraccionSangre(vista.txtFechaExtraccion.getText(),Volumen, 
                                    vista.comboGrupoSang.getSelectedItem().toString(),vista.comboRH.getSelectedItem().toString(),
                                    vista.comboDonantes.getSelectedItem().toString());
                            
                            //Repositorio.extracciones.agregar(c); //AGREGAR AL REPO
                            modeloC.registrarExtraccion(c);
                            //PARECIDO A LO DE SOLICITUD:
                            
                            int idSangre=modeloU.idSangre(vista.comboGrupoSang.getSelectedItem().toString() ,vista.comboRH.getSelectedItem().toString());
                            
                            modeloU.añadir(idSangre, Volumen);

                            Sangre u=new Sangre(Volumen,vista.comboGrupoSang.getSelectedItem().toString(),vista.comboRH.getSelectedItem().toString());          
                            Almacen.UnidadesSangre.add(u);

                            //Prueba para vizualizar las unidades
                            System.out.println(Almacen.UnidadesSangre);
                            System.out.println("");
                            
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
                int fila = vista.tblExtRepo.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar alguna Extraccion");
                } else {
                    int valor = Integer.parseInt(vista.tblExtRepo.getValueAt(fila, 0).toString());
                    String tipo = vista.tblExtRepo.getValueAt(fila, 3).toString();//codigo de la solicitud
                    String rh = vista.tblExtRepo.getValueAt(fila, 4).toString();//codigo de la solicitud
                    int idSangre = modeloU.idSangre(tipo, rh);
                    System.out.println(idSangre);
                    System.out.println(tipo+rh);
                    //modeloU.añadir(idSangre, codEditar);
                    float volumenRegresa =Float.parseFloat(vista.tblExtRepo.getValueAt(fila, 2).toString());//codigo de la solicitud
                    modeloU.disminuir(idSangre, volumenRegresa);
                    //Repositorio.extracciones.eliminar(valor);
                    
                    modeloC.eliminarExtraccion(valor);
                    actualizarTabla();
                    System.out.println("Cita eliminada");
                    JOptionPane.showMessageDialog(null, "Extraccion eliminada");
                }
            }
        }
        );
    }
/*
    public void actualizarTabla2() {
        //lo del jtable
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatos(), this.modelo.getCabecera());
        this.vista.tblExtRepo.setModel(modelotabla);
    }*/
    
    public void actualizarTabla(){
        this.vista.tblExtRepo.setModel(ConsultasExtraccion.listar());
        this.vista.tblExtRepo.getTableHeader().setReorderingAllowed(false);//para que no se mueva
    }
    
    public void limpiarCampos(){
        //fecha talla peso diagnostico tratamiento
        this.vista.txtFechaExtraccion.setText("");
        this.vista.txtVolumen.setText("");
        
        
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.tblExtRepo.setEditingColumn(2);
        DefaultComboBoxModel modeloCboEmpleados = new DefaultComboBoxModel();
        modeloD.comboDonante(modeloCboEmpleados);
        this.vista.comboDonantes.setModel(modeloCboEmpleados);
        //lo del combobox donantes
        /*
        
        
        for (Donante e : Repositorio.donantes.getDatosCombo()) {
            modeloCboEmpleados.addElement(e);
        }
        //le doy al combo del form el modelo
        this.vista.comboDonantes.setModel(modeloCboEmpleados);
*/
        //lo del jtable
        
        actualizarTabla();
    }
}
