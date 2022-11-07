
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
    
    private int codEditar=0;//codigo del donante a editar

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
                            System.out.println("Donante AGREGADO");
                            JOptionPane.showMessageDialog(null, "Donante Agregado");
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
        
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblDonanteRepo.getSelectedRow();//seleccion de fila de la tabla
                
                //eliminar
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un donante");
                } else {
                    int valor = Integer.parseInt(vista.tblDonanteRepo.getValueAt(fila, 0).toString());//codigo de donante
                    Repositorio.donantes.eliminar(valor);//metodo para eliminar donantes
                    actualizarTabla();//actualizamos
                    System.out.println("Donante Eliminado");
                    JOptionPane.showMessageDialog(null, "Donante Eliminado");
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
        
        
        this.vista.btnEditar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblDonanteRepo.getSelectedRow();//seleccion de fila de la tabla
                
                //eliminar
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un donante");
                } else {
                    int valor = Integer.parseInt(vista.tblDonanteRepo.getValueAt(fila, 0).toString());//codigo de donante
                    codEditar=valor;
                    Donante donante = modelo.devolverDonante(valor);
                    llenarCampos(donante);
                    
                    //Desabilitamos los demas botones
                    vista.btnCancelar.setEnabled(false);
                    vista.btnEditar1.setEnabled(false);
                    vista.btnEliminar.setEnabled(false);
                    vista.btnRegistrar.setEnabled(false);
                    //habilitamos el boton que confirma el cambio
                    vista.btnEditarOK.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Actualice los datos del donante");
                    
                }

            }
        }
        );
        
        this.vista.btnEditarOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numTelefono;
                int edad;
                //donante
                Donante donante = modelo.devolverDonante(codEditar);
                
                if (vista.txtFechaNacimiento.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                        || vista.txtNombreDonante.getText().isEmpty() || vista.txtCorreo.getText().isEmpty()
                        || vista.txtDNIEmpleado.getText().isEmpty() || vista.lblTelefonoEmpleado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        numTelefono = Integer.parseInt(vista.lblTelefonoEmpleado.getText());
                        try {
                            edad = Integer.parseInt(vista.txtEdad.getText());
                            donante.setNombre(vista.txtNombreDonante.getText());
                            donante.setCorreo(vista.txtCorreo.getText());
                            donante.setDNI(vista.txtDNIEmpleado.getText());
                            donante.setTelefono(numTelefono);
                            donante.setFechaNac(vista.txtFechaNacimiento.getText());
                            donante.setEdad(edad);
                            
                            JOptionPane.showMessageDialog(null, "Donante editado");
                            actualizarTabla();
                            limpiarCampos();
                            
                            //activamos los demas botones
                            vista.btnCancelar.setEnabled(true);
                            vista.btnEditar1.setEnabled(true);
                            vista.btnEliminar.setEnabled(true);
                            vista.btnRegistrar.setEnabled(true);
                            //habilitamos el boton que confirma el cambio
                            vista.btnEditarOK.setEnabled(false);
                            
                            codEditar=0;
                            
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
        
    }
    public void actualizarTabla() {
        //lo del jtable
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatos(), this.modelo.getCabecera());
        this.vista.tblDonanteRepo.setModel(modelotabla);
    }
    public void limpiarCampos(){
        this.vista.txtNombreDonante.setText("");
        this.vista.txtCorreo.setText("");
        this.vista.txtDNIEmpleado.setText("");
        this.vista.lblTelefonoEmpleado.setText("");
        this.vista.txtFechaNacimiento.setText("");
        this.vista.txtEdad.setText("");
    }
    public void llenarCampos(Donante donante){
        this.vista.txtNombreDonante.setText(donante.getNombre());
        this.vista.txtCorreo.setText(donante.getCorreo());
        this.vista.txtDNIEmpleado.setText(donante.getDNI());
        this.vista.lblTelefonoEmpleado.setText(String.valueOf(donante.getTelefono()));
        this.vista.txtFechaNacimiento.setText(donante.getFechaNac());
        this.vista.txtEdad.setText(String.valueOf(donante.getEdad()));
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        vista.btnEditarOK.setEnabled(false);
        
        actualizarTabla();
    }
}
