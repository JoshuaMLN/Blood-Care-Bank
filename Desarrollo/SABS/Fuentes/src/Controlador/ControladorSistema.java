
package Controlador;

import Datos.Repositorio;
import Modelo.ConsultasAdministradores;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import Vista.frmPrincipal;
import Vista.frmSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorSistema {
    private frmSistema vista;
    private UsuarioArreglo modelo;
    
    
    public ControladorSistema(UsuarioArreglo modelo, frmSistema vista) {
        this.vista = vista;
        this.modelo=modelo;
        
        this.vista.btnIngresar.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Usuario u = modelo.ingresar( vista.txtUsuario.getText(),
                            vista.txtContraseña.getText());
                    
                    if(u != null){
                        System.out.println( "Ok: "+u);
                        Repositorio.usuario_validado = u;
                        ControladorPrincipal controlador = new ControladorPrincipal( u, new frmPrincipal() );
                        controlador.iniciar();
                        vista.dispose();
                        
                    }else{
                        vista.txtContraseña.setText("");
                        JOptionPane.showMessageDialog(vista, "Intente nuevamente");
                    }
                }
            }
        );
        
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    System.exit(0); 
                }
            }
        );
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.txtUsuario.setText("");
        this.vista.txtContraseña.setText("");
        this.vista.setVisible(true);
    }
}
