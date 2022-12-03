
package Modelo;


public class ExtraccionArreglo{
    private ExtraccionSangre[] extracciones;
    private int indice;
    private final String[] cabecera =  {"CODIGO",
                            "FECHA","DONANTE.","VOL.", "GRUPO","RH"};
    
    public ExtraccionArreglo (int tamano) {
        this.extracciones = new ExtraccionSangre[tamano];
        this.indice = 0;
    }
    
    public void agregar(ExtraccionSangre extracciones){
        this.extracciones[this.indice] = extracciones;
        this.indice++; 
    }
    
    public void eliminar(int x) {
        int numero=0;
        if (x >= 0) {
            for (int i = x; i < extracciones.length - 1; i++) {
                extracciones[i] = extracciones[i + 1];
                extracciones[i + 1] = null;
                numero=i;
            }
            
        }else{
            System.out.println("Posicion invalida");
        }
        indice--;

    }
    
    public String[] getCabecera() {
        return cabecera;
    }
    
    public boolean isVacio() {
        return this.indice==0;
    }
    
    public Object[][] getDatos(){
        Object resultado[][] = new Object[this.indice][8];
        if(!isVacio()){
            for(int indice = 0; indice< this.indice;indice++){
                resultado[indice][0] = this.extracciones[indice].getCodigo();
                resultado[indice][1] = this.extracciones[indice].getFecha();
                resultado[indice][2] = this.extracciones[indice].getDonante();
                resultado[indice][3] = this.extracciones[indice].getVolumen();
                resultado[indice][4] = this.extracciones[indice].getGrupoSanguineo();
                resultado[indice][5] = this.extracciones[indice].getRh();

                
            }
        }
        return resultado;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        for(int i=0 ; i < this.indice; i++){
            resultado = resultado + this.extracciones[i]+"\n\n";
        }
        return resultado;
    }
    
    
}