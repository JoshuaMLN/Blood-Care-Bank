package Modelo;

/**
 *
 * @author Garyn
 */
public class Administrador extends Usuario{
    
    private int identificador;
    private static int id = 0;
    
    public Administrador(String Usuario, String Contrasena) {
        super(Usuario, Contrasena);
        id++;
        identificador = id;
    }
    
}