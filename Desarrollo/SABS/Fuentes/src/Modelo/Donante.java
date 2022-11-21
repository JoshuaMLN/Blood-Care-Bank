
package Modelo;


public class Donante extends Persona {
    private String fechaNac;
    private static int contador=0;
    private int codigo;
    private int edad;

    public Donante() {
    }

    
    public Donante(String fechaNac,int edad, String nombre, String correo, String DNI, String telefono) {
        super(nombre, correo, DNI, telefono);
        this.codigo = contador;
        contador++;
        this.fechaNac = fechaNac;
        this.edad = edad;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
