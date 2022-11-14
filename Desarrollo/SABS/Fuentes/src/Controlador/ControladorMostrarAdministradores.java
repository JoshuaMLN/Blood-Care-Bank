/**
 *
 * @author Garyn
 */

package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class ControladorMostrarAdministradores {
    private frmAdministradores vista;
    private UsuarioArreglo modelo;
    
    public ControladorMostrarAdministradores(frmAdministradores vista, UsuarioArreglo modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);

    }
}