
package Datos;

import Modelo.DonanteArreglo;
import Modelo.ExtraccionArreglo;
import Modelo.Usuario;
import Modelo.UsuarioArreglo;
import java.io.Serializable;

public class Repositorio implements Serializable {
    
    public static UsuarioArreglo usuarios = new UsuarioArreglo(3);
    public static Usuario usuario_validado;
    public static DonanteArreglo donantes = new DonanteArreglo(10);
    public static ExtraccionArreglo extracciones = new ExtraccionArreglo(15);
    
    
}
