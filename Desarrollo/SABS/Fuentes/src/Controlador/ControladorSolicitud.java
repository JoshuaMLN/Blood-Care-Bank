
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class ControladorSolicitud {
    private frmSolicitud vista;
    private SolicitudArreglo modelo;
    private int codEditar=0;//codigo del donante a editar
    
    public ControladorSolicitud(frmSolicitud vista, SolicitudArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCancelar.addActionListener(new ActionListener() {
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
                int Cantidad;
                
                if(vista.text_Motivo.getText().isEmpty()||vista.text_Cantidad.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } 
                else{
                    Nombre = String.valueOf(vista.text_Nombre.getText());
                    Motivo = String.valueOf(vista.text_Motivo.getText());
                    if(vista.Sangre_A.isSelected()){
                        GrupoSanguineo=vista.Sangre_A.getText();
                    }
                    else if(vista.Sangre_B.isSelected()){
                        GrupoSanguineo=vista.Sangre_B.getText();
                    }
                    else if(vista.Sangre_AB.isSelected()){
                        GrupoSanguineo=vista.Sangre_AB.getText();
                    }
                    else if(vista.Sangre_O.isSelected()){
                        GrupoSanguineo=vista.Sangre_O.getText();
                    }
                    if(vista.Sangre_Pos.isSelected()){
                        Rh = vista.Sangre_Pos.getText();;
                    }
                    else if(vista.Sangre_Neg.isSelected()){
                        Rh = vista.Sangre_Neg.getText();;
                    }
                    Cantidad = Integer.parseInt(vista.text_Cantidad.getText());
                    Solicitud em = new Solicitud(Nombre,Motivo,GrupoSanguineo,Rh,Cantidad);
                    Repositorio.solicitudes.agregar(em);
                    System.out.println("Solicitud AGREGADO");
                    JOptionPane.showMessageDialog(null, "Solicitud Agregada");
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
                    Repositorio.solicitudes.eliminar(valor);//metodo para eliminar solicitudes
                    actualizarTabla();//actualizamos
                    System.out.println("Solicitud Eliminada");
                    JOptionPane.showMessageDialog(null, "Solicitud Eliminada");
                }
            }
        }
        );
    }
    public void actualizarTabla() {
        DefaultTableModel modelotabla = new DefaultTableModel(this.modelo.getDatos(), this.modelo.getCabecera());
        this.vista.tbl_Solicitudes.setModel(modelotabla);
    }
    public void limpiarCampos(){
        this.vista.text_Motivo.setText("");
        this.vista.text_Cantidad.setText("");
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        actualizarTabla();
    }
}
