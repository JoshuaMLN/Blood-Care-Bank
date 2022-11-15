/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
/**
 *
 * @author Joshua ML
 */
import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ControladorSolicitud {
    private frmSolicitud vista;
    private UsuarioArreglo modelo;
    public ControladorSolicitud(frmSolicitud vista, UsuarioArreglo modelo) {
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
                String usuario;
                String[] Motivo;
                String Tipo_Sangre;
                String Cantidad;
                if(vista.text_Motivo.getText().isEmpty()||vista.text_Cantidad.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                else
                    try{
                        Motivo = Integer.parseInt(vista.txt_Motivo.getText());
                    }
                }
            }
        );
    }
    public void limpiarCampos(){
        this.vista.text_Motivo.setText("");
        this.vista.text_Cantidad.setText("");
    }
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
