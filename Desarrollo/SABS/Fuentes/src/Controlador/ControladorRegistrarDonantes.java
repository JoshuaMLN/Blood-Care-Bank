
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorRegistrarDonantes {
    private frmDonantes vista;
    private DonanteArreglo modelo;
    
    private ConsultasDonante modeloC = new ConsultasDonante();
    
    DefaultTableModel modelotabla = new DefaultTableModel();
    
    private int codEditar=0;//codigo del donante a editar

    public ControladorRegistrarDonantes(frmDonantes vista, DonanteArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String numTelefono;
                int edad;
                if (vista.txtCorreo.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                        || vista.txtNombreDonante.getText().isEmpty() || vista.txtFechaNac.getText().isEmpty()
                        || vista.txtDNIEmpleado.getText().isEmpty() || vista.lblTelefonoEmpleado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        //numTelefono = Integer.parseInt(vista.lblTelefonoEmpleado.getText());
                        numTelefono=vista.lblTelefonoEmpleado.getText();
                        try {
                            edad = Integer.parseInt(vista.txtEdad.getText());
                            Donante em = new Donante(vista.txtFechaNac.getText(),
                                    edad, vista.txtNombreDonante.getText(),
                                    vista.txtCorreo.getText(), vista.txtDNIEmpleado.getText(),
                                    numTelefono);
                            //Repositorio.donantes.agregar(em);
                            modeloC.registrarDonante(em);
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
                    //Repositorio.donantes.eliminar(valor);//metodo para eliminar donantes
                    modeloC.eliminarDonante(valor);
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
                    Donante donante = modeloC.buscar(valor);
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
                String numTelefono;
                int edad;
                //donante
                Donante donante = new Donante();
                
                if (vista.txtCorreo.getText().isEmpty() || vista.txtEdad.getText().isEmpty()
                        || vista.txtNombreDonante.getText().isEmpty() || vista.txtFechaNac.getText().isEmpty()
                        || vista.txtDNIEmpleado.getText().isEmpty() || vista.lblTelefonoEmpleado.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        //numTelefono = Integer.parseInt(vista.lblTelefonoEmpleado.getText());
                        numTelefono=vista.lblTelefonoEmpleado.getText();
                        try {
                            edad = Integer.parseInt(vista.txtEdad.getText());
                            donante.setNombre(vista.txtNombreDonante.getText());
                            donante.setFechaNac(vista.txtFechaNac.getText());
                            donante.setDNI(vista.txtDNIEmpleado.getText());
                            donante.setEdad(edad);
                            donante.setTelefono(numTelefono);
                            donante.setCorreo(vista.txtCorreo.getText());

                            modeloC.editaDonate(codEditar, donante);
                            
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
    
    public void actualizarTabla(){
        this.vista.tblDonanteRepo.setModel(ConsultasDonante.listar());
        this.vista.tblDonanteRepo.getTableHeader().setReorderingAllowed(false);//para que no se mueva
    }
    
    
    
    public void limpiarCampos(){
        this.vista.txtNombreDonante.setText("");
        this.vista.txtFechaNac.setText("");
        this.vista.txtDNIEmpleado.setText("");
        this.vista.lblTelefonoEmpleado.setText("");
        this.vista.txtCorreo.setText("");
        this.vista.txtEdad.setText("");
    }
    public void llenarCampos(Donante donante){
        this.vista.txtNombreDonante.setText(donante.getNombre());
        this.vista.txtFechaNac.setText(donante.getFechaNac());
        this.vista.txtDNIEmpleado.setText(donante.getDNI());
        this.vista.lblTelefonoEmpleado.setText(String.valueOf(donante.getTelefono()));
        this.vista.txtCorreo.setText(donante.getCorreo());
        this.vista.txtEdad.setText(String.valueOf(donante.getEdad()));
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        vista.btnEditarOK.setEnabled(false);
        
        actualizarTabla();
    }
}
