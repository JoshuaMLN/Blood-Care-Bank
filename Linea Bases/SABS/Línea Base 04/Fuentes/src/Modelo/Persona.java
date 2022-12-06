
package Modelo;

//abstract 
public abstract class Persona {
    protected String nombre;
    protected String correo;
    protected String DNI;
    protected String telefono;

    public Persona() {
    }
    
    
    //constructor, get ,set, 

    public Persona(String nombre, String correo, String DNI, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.DNI = DNI;
        this.telefono = telefono;
              
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}