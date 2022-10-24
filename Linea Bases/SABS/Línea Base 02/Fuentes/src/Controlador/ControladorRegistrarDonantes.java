
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorRegistrarDonantes {
    private frmDonantes vista;
    private DonanteArreglo modelo;

    public ControladorRegistrarDonantes(frmDonantes vista, DonanteArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int numTelefono;
                int edad;
                if (vista.txtFechaNacimiento.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                        || vista.txtNombreDonante.getText().isEmpty() || vista.txtCorreo.getText().isEmpty()
                        || vista.txtDNIEmpleado.getText().isEmpty() || vista.lblTelefonoEmpleado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        numTelefono = Integer.parseInt(vista.lblTelefonoEmpleado.getText());
                        try {
                            edad = Integer.parseInt(vista.txtEdad.getText());
                            Donante em = new Donante(vista.txtFechaNacimiento.getText(),
                                    edad, vista.txtNombreDonante.getText(),
                                    vista.txtCorreo.getText(), vista.txtDNIEmpleado.getText(),
                                    numTelefono);
                            Repositorio.donantes.agregar(em);
                            System.out.println("Empleado AGREGADO");
                            JOptionPane.showMessageDialog(null, "Donante Agregada");
                            actualizarTabla();
                            limpiarCampos();
                        } catch (NumberFormatException ex1) {
                            JOptionPane.showMessageDialog(null, "Dato invalido");
                        }
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Num. celular invalido");
                    }
                }

            }
        }      
        );
        this.vista.btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                //en lugar de crear otro usuario debemos traerlo del repo
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblEmpleadoRepo.getSelectedRow();//seleccion de fila de la tabla
                
                //eliminar
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una empleado");
                } else {
                    int valor = Integer.parseInt(vista.tblEmpleadoRepo.getValueAt(fila, 0).toString());//codigo de donante
                    Repositorio.donantes.eliminar(valor);//metodo para eliminar donantes
                    actualizarTabla();//actualizamos
                    System.out.println("Empleado Eliminado");
                    JOptionPane.showMessageDialog(null, "Empleado Eliminado");
                }

            }
        }
        );
        
    }
    public void actualizarTabla() {
        //lo del jtable
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatos(), this.modelo.getCabecera());
        this.vista.tblEmpleadoRepo.setModel(modelotabla);
    }
    public void limpiarCampos(){
        this.vista.txtNombreDonante.setText("");
        this.vista.txtCorreo.setText("");
        this.vista.txtDNIEmpleado.setText("");
        this.vista.lblTelefonoEmpleado.setText("");
        this.vista.txtFechaNacimiento.setText("");
        this.vista.txtEdad.setText("");
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        actualizarTabla();
    }
}
