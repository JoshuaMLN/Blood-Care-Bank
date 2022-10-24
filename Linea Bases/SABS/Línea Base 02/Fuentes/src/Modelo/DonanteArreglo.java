
package Modelo;


public class DonanteArreglo {
    private Donante[] empleados;
    private int indice;
    private final String[] cabecera =  {"CODIGO","NOMBRE",
                            "FECHA NAC.","DNI", "TELEFONO",
                            "CORREO", "EDAD"};
    
    public DonanteArreglo(int tamano) {
        this.empleados = new Donante[tamano];
        this.indice = 0;
    }
    
    public void agregar(Donante empleado){
        this.empleados[this.indice] = empleado;
        this.indice++; 
    }
    
    public void eliminar(int x) {
        
        if (x >= 0) {
            for (int i = x; i < empleados.length - 1; i++) {
                empleados[i] = empleados[i + 1];
                empleados[i + 1] = null;
                
            }
            //System.out.println(ClientePersonas[numero].getNombre()+" fue eliminado.");
        }else{
            System.out.println("Posicion invalida");
        }
        indice--;

    }
    
    //Necesario para mostrar datos en tabla
    
    public String[] getCabecera() {
        return cabecera;
    }
    
    
    public boolean isVacio() {
        return this.indice==0;
    }
   
    
    public Object[][] getDatos(){
        Object resultado[][] = new Object[this.indice][7];
        if(!isVacio()){
            for(int indice = 0; indice< this.indice;indice++){
                resultado[indice][0] = this.empleados[indice].getCodigo();
                resultado[indice][1] = this.empleados[indice].getNombre();
                resultado[indice][2] = this.empleados[indice].getApellido();
                resultado[indice][3] = this.empleados[indice].getDNI();
                resultado[indice][4] = this.empleados[indice].getTelefono();
                resultado[indice][5] = this.empleados[indice].getEspecialidad();
                resultado[indice][6] = this.empleados[indice].getEdad();
                
            }
        }
        return resultado;
    }
    
    //devolver empleado a partir de su codigo
    public Donante devolverEmpleado(int codigo) {
        Donante resultado = null;
         for(int i=0; i < empleados.length; i++){
            if( codigo==this.empleados[i].getCodigo() ) {
                resultado = this.empleados[i];
                break;
            }
        }
        return resultado;
    }
    
    
    public Donante[] getDatosCombo() {
        Donante resultado[] = null;
        if (!isVacio()) {
            resultado = new Donante[this.indice];
            for (int i = 0; i < this.indice; i++) {
                resultado[i] = this.empleados[i];
            }
        }
        return resultado;
    }
    
    
    @Override
    public String toString() {
        String resultado = "";
        for(int i=0 ; i < this.indice; i++){
            resultado = resultado + this.empleados[i]+"\n";
        }
        return resultado;
    }
}
