
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Datos.*;


public class ControladorPrincipal {
    private frmPrincipal vista;
    private Usuario modelo;
    
    
    public ControladorPrincipal(Usuario modelo, frmPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnDonantes.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorRegistrarDonantes controlador = new ControladorRegistrarDonantes (new frmDonantes(), Repositorio.donantes);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnExtraccion.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorExtraccion controlador = new ControladorExtraccion (new frmExtraccion(), Repositorio.extracciones);
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    modelo.salir();
                    ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
                    controlador.iniciar();
                    vista.dispose();
                }
            }
        );

    } 
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        //traer usuario validado y ponerlo en el label
        this.vista.lblUsuario.setText(modelo.getUsuario());
    }

    
}
