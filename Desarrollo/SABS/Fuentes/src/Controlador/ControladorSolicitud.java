
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class ControladorSolicitud {
    private frmSolicitud vista;
    private SolicitudArreglo modelo;
    
    private ConsultasSolicitud modeloC = new ConsultasSolicitud();
    private ConsultasSangre modeloU = new ConsultasSangre();
    private int codEditar=0;//codigo del donante a editar
    
    public ControladorSolicitud(frmSolicitud vista, SolicitudArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String Nombre = null;
                String Motivo = null;
                String GrupoSanguineo = null;
                String Rh = null;
                float Cantidad;

                if(vista.text_Nombre.getText().isEmpty()||vista.text_Motivo.getText().isEmpty()||vista.text_Cantidad.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                }
                else{
                    Nombre = String.valueOf(vista.text_Nombre.getText());
                    Motivo = String.valueOf(vista.text_Motivo.getText());
                    for(Enumeration i=vista.Sangre.getElements(); i.hasMoreElements();)//Ver que boton del grupo SANGRE esta presionado
                    {
                        JRadioButton btn = (JRadioButton)i.nextElement();
                        if (btn.getModel() == vista.Sangre.getSelection())
                        {
                            GrupoSanguineo=btn.getText();
                        }
                    }
                    
                    for(Enumeration i=vista.Signo.getElements(); i.hasMoreElements();)//Ver que boton del grupo SIGNO esta presionado
                    {
                        JRadioButton btn = (JRadioButton)i.nextElement();
                        if (btn.getModel() == vista.Signo.getSelection())
                        {
                            Rh=btn.getText();
                        }
                    }
                    Cantidad = Float.parseFloat(vista.text_Cantidad.getText());
                    Solicitud em = new Solicitud(Nombre,Motivo,GrupoSanguineo,Rh,Cantidad);
                    int idSangre = modeloU.idSangre(GrupoSanguineo, Rh);
                    System.out.println(modeloU.idSangre("A", "+"));
                    System.out.println(idSangre);
                    System.out.println(Cantidad);
                    System.out.println(modeloU.verificaVolumen(idSangre));
                    System.out.println("");
                    
                    
                    if (modeloU.verificaVolumen(idSangre)>=Cantidad){
                        modeloU.disminuir(idSangre, Cantidad);
                        //Repositorio.solicitudes.agregar(em);
                        modeloC.registrarSolicitud(em);
                        System.out.println("Solicitud AGREGADA");
                        JOptionPane.showMessageDialog(null, "Solicitud Agregada");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No se cuenta con esa cantidad de sangre.");
                    }
                    actualizarTabla();
                    limpiarCampos();
                }
            }
        }
        );
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tbl_Solicitudes.getSelectedRow();
                
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una solicitud");
                }else {
                    int valor = Integer.parseInt(vista.tbl_Solicitudes.getValueAt(fila, 0).toString());//codigo de la solicitud
                    //Repositorio.solicitudes.eliminar(valor);
                    modeloC.eliminarSolicitud(valor);
                    actualizarTabla();//actualizamos
                    System.out.println("Solicitud Eliminada");
                    
                    JOptionPane.showMessageDialog(null, "Solicitud Eliminada");
                    
                }
            }
        }
        );
    }
    public void actualizarTabla(){
        this.vista.tbl_Solicitudes.setModel(ConsultasSolicitud.listar());
    }
    public void limpiarCampos(){
        this.vista.text_Nombre.setText("");
        this.vista.text_Motivo.setText("");
        this.vista.text_Cantidad.setText("");
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        actualizarTabla();

    }
}

