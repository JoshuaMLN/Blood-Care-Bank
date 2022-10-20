
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorRegistrarEmpleados {
    private frmEmpleado vista;
    private EmpleadoArreglo modelo;

    public ControladorRegistrarEmpleados(frmEmpleado vista, EmpleadoArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int numTelefono;
                float sueldo;
                if (vista.txtEspecialidad.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                        || vista.txtNombreDonante.getText().isEmpty() || vista.txtCorreo.getText().isEmpty()
                        || vista.txtDNIEmpleado.getText().isEmpty() || vista.lblTelefonoEmpleado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        numTelefono = Integer.parseInt(vista.lblTelefonoEmpleado.getText());
                        try {
                            sueldo = Float.parseFloat(vista.txtEdad.getText());
                            Empleado em = new Empleado(vista.txtEspecialidad.getText(),
                                    sueldo, vista.txtNombreDonante.getText(),
                                    vista.txtCorreo.getText(), vista.txtDNIEmpleado.getText(),
                                    numTelefono);
                            Repositorio.empleados.agregar(em);
                            System.out.println("Empleado AGREGADO");
                            JOptionPane.showMessageDialog(null, "Empleado Agregada");
                            actualizarTabla();
                            limpiarCampos();
                        } catch (NumberFormatException ex1) {
                            JOptionPane.showMessageDialog(null, "Sueldo invalido");
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
                    int valor = Integer.parseInt(vista.tblEmpleadoRepo.getValueAt(fila, 0).toString());//codigo de empleado
                    Repositorio.empleados.eliminar(valor);//metodo para eliminar empleados
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
        this.vista.txtEspecialidad.setText("");
        this.vista.txtEdad.setText("");
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        actualizarTabla();
    }
}
