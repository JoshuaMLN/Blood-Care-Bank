
package Datos;

import Modelo.EmpleadoArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import java.io.Serializable;

public class Repositorio implements Serializable {
    
    public static UsuarioArreglo usuarios = new UsuarioArreglo(3);
    public static Usuario usuario_validado;
    public static EmpleadoArreglo empleados = new EmpleadoArreglo(10);
    
}
