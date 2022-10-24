
package Modelo;


public class Donante extends Persona {
    private String especialidad;
    private static int contador=0;
    private int codigo;
    private int edad;

    
    public Donante(String especialidad,int edad, String nombre, String apellido, String DNI, int telefono) {
        super(nombre, apellido, DNI, telefono);
        this.codigo = contador;
        contador++;
        this.especialidad = especialidad;
        this.edad = edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
