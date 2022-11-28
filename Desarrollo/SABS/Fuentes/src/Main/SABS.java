
package Main;

import Controlador.ControladorSistema;
import Datos.Repositorio;
import Datos.Almacen;
import Modelo.Administrador;
import Modelo.ConsultasSangre;
import Modelo.Donante;
import Modelo.Sangre;
import Modelo.Usuario;
import Modelo.Solicitud;
import Vista.frmSistema;

public class SABS {
    public static void main(String[] args) {
        
        
        Repositorio.usuarios.agregar(new Administrador("user", "123"));
        Repositorio.usuarios.agregar(new Administrador("admin1", "1111"));
        Repositorio.usuarios.agregar(new Administrador("admin2", "2222"));
        Repositorio.usuarios.agregar(new Administrador("admin3","321"));
        Repositorio.usuarios.agregar(new Administrador("user2", "123456"));
        Repositorio.usuarios.agregar(new Administrador("user3", "12345"));
        Repositorio.usuarios.agregar(new Administrador("user4", "1234567"));

        Donante empleado1= new Donante("josefina@gmail.com", 16, "Josefina", "12-12-12", "31501974", "954201376");

        Almacen.UnidadesSangre.add(new Sangre(1,"A","+"));
        Almacen.UnidadesSangre.add(new Sangre(2,"B","-"));
        Almacen.UnidadesSangre.add(new Sangre(10,"O","-"));
        Almacen.UnidadesSangre.add(new Sangre(1,"B","+"));
        Almacen.UnidadesSangre.add(new Sangre(2,"A","-"));
        Almacen.UnidadesSangre.add(new Sangre(1,"O","+"));
        Almacen.UnidadesSangre.add(new Sangre(7,"AB","+"));
        Almacen.UnidadesSangre.add(new Sangre(1,"AB","-"));
        Almacen.UnidadesSangre.add(new Sangre(15,"AB","-"));
        //Donante empleado1= new Donante("josefina@gmail.com", 16, "Josefina", "12-12-12", "31501974", 954201376);

        Repositorio.donantes.agregar(empleado1);
        Donante empleado2= new Donante("joseph@gmail.com", 18, "Joseph", "11-11-11", "74105896", "983511012");
        Repositorio.donantes.agregar(empleado2);
        Solicitud solicitud1= new Solicitud("EsSalud","Pacientes con cancer", "A", "+", 10);
        Repositorio.solicitudes.agregar(solicitud1);
        //Inicio de controlador Sistema (Login)
        //prueba de consulta sangre:
        /*
        ConsultasSangre c=new ConsultasSangre();
        System.out.println(c.verificaVolumen(1));
        c.añadir(1, 15);
        System.out.println(c.verificaVolumen(1));
        c.disminuir(1,30);
        System.out.println(c.verificaVolumen(1));
        System.out.println(c.idSangre("AB", "-"));
        */
        ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
        controlador.iniciar();
    }
}
