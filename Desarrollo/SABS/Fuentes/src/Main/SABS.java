
package Main;

import Controlador.ControladorSistema;
import Datos.Repositorio;
import Modelo.Empleado;
import Modelo.Usuario;
import Vista.frmSistema;

public class SABS {
    public static void main(String[] args) {
        
        Repositorio.usuarios.agregar(new Usuario("admin", "123"));
        Repositorio.usuarios.agregar(new Usuario("user", "000"));       
        Empleado empleado1= new Empleado("Recepcionista", 1600, "Josefina", "Suarez", "31501974", 954201376);
        Repositorio.empleados.agregar(empleado1);
        Empleado empleado2= new Empleado("Conserje", 1500, "Joseph", "Kurao", "74105896", 983511012);
        Repositorio.empleados.agregar(empleado2);
        
        //Inicio de controlador Sistema (Login)
        ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
        controlador.iniciar();
    }
}
