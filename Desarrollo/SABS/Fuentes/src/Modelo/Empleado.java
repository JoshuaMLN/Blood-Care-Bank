
package Modelo;


public class Empleado extends Persona {
    private String especialidad;
    private static int contador=0;
    private int codigo;
    private float sueldo;

    
    public Empleado(String especialidad,float sueldo, String nombre, String apellido, String DNI, int telefono) {
        super(nombre, apellido, DNI, telefono);
        this.codigo = contador;
        contador++;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
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

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
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
