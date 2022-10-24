
package Modelo;

//abstract 
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String DNI;
    protected int telefono;
    
    
    //constructor, get ,set, 

    public Persona(String nombre, String apellido, String DNI, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.telefono = telefono;
              
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
}