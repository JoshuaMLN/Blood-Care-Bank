
package Main;

import Controlador.ControladorSistema;
import Datos.Repositorio;
import Modelo.Donante;
import Modelo.Usuario;
import Vista.frmSistema;

public class SABS {
    public static void main(String[] args) {
        
        Repositorio.usuarios.agregar(new Usuario("admin", "123"));
        Repositorio.usuarios.agregar(new Usuario("user", "000"));       
        Donante empleado1= new Donante("josefina@gmail.com", 16, "Josefina", "12-12-12", "31501974", 954201376);
        Repositorio.donantes.agregar(empleado1);
        Donante empleado2= new Donante("joseph@gmail.com", 18, "Joseph", "11-11-11", "74105896", 983511012);
        Repositorio.donantes.agregar(empleado2);
        
        //Inicio de controlador Sistema (Login)
        ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
        controlador.iniciar();
    }
}
