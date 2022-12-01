package Modelo;
/*Autor: JoshuaMLN*/
import java.io.Serializable;

public class Usuario implements Serializable{   
    private String Usuario;
    private String Contrasena;
    private boolean Estado;

    public Usuario() {
    }
    

    public Usuario(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.Estado = false;
    }
    
    public boolean Actividad() {
        return Estado;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    public boolean ingresar(String user, String password){
        boolean result = false;
        if(this.Usuario.equalsIgnoreCase(user) && 
           this.Contrasena.equals(password)   &&
           !Actividad())
        {
            this.Estado = true;
            result = true;
        }            
        return result; 
    }
    
    public boolean salir(){
        boolean result = false;
        if(this.Estado){
            this.Estado = false;
            result = true;
        }
        return result;
    }
}