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
import javax.swing.table.DefaultTableModel;

public class ControladorMostrarAdministradores {
    private frmAdministradores vista;
    private UsuarioArreglo modelo;
    
    
    public ControladorMostrarAdministradores(frmAdministradores vista, UsuarioArreglo modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        setModelo();
        
        this.vista.btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
    }
    
    private void setModelo(){
        String[] cabecera = {"USUARIO", "CONTRASEÑA"};
        /*
        DefaultTableModel admins = new DefaultTableModel(this.modelo.getAdmin(), cabecera){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };*/
        //this.vista.tblAdministradores.setModel(admins);
        this.vista.tblAdministradores.setModel(ConsultasAdministradores.listar());
        this.vista.tblAdministradores.getTableHeader().setReorderingAllowed(false);//no mueva
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);

    }
}