
package Modelo;

public class SolicitudArreglo {
    private Solicitud[] vec_solicitudes;
    private int index;
    private final String[] cabecera =  {"CODIGO","NOMBRE","MOTIVO","GRUPO SANG.",
                                        "RH","CANTIDAD","FECHA Y HORA"};

    public SolicitudArreglo(int tamano) {
        this.vec_solicitudes = new Solicitud[tamano];
        this.index = 0;
    }
    public void agregar(Solicitud vec_solicitudes){
        this.vec_solicitudes[this.index] = vec_solicitudes;
        this.index++; 
    }
    public void eliminar(int x) {
        if (x >= 0) {
            for (int i = x; i < vec_solicitudes.length - 1; i++) {
                vec_solicitudes[i] = vec_solicitudes[i + 1];
                vec_solicitudes[i + 1] = null;
            }
        }else{
            System.out.println("Posicion invalida");
        }
        index--;
    }
    public String[] getCabecera() {
        return cabecera;
    }
    public boolean isVacio() {
        return this.index==0;
    }
    public Object[][] getDatos(){
        Object resultado[][] = new Object[this.index][cabecera.length];
        if(!isVacio()){
            for(int index = 0; index< this.index;index++){
                resultado[index][0] = this.vec_solicitudes[index].getCodigo();
                resultado[index][1] = this.vec_solicitudes[index].getNombre();
                resultado[index][2] = this.vec_solicitudes[index].getMotivo();
                resultado[index][3] = this.vec_solicitudes[index].getGrupoSanguineo();
                resultado[index][4] = this.vec_solicitudes[index].getRh();
                resultado[index][5] = this.vec_solicitudes[index].getCantidad();
                resultado[index][6] = this.vec_solicitudes[index].getFecha();
            }
        }
        return resultado;
    }
    public Solicitud devolverSolicitud(int codigo) {
        Solicitud resultado = null;
         for(int i=0; i < vec_solicitudes.length; i++){
            if( codigo==this.vec_solicitudes[i].getCodigo() ) {
                resultado = this.vec_solicitudes[i];
                break;
            }
        }
        return resultado;
    }
    public Solicitud[] getDatosCombo() {
        Solicitud resultado[] = null;
        if (!isVacio()) {
            resultado = new Solicitud[this.index];
            for (int i = 0; i < this.index; i++) {
                resultado[i] = this.vec_solicitudes[i];
            }
        }
        return resultado;
    }
    @Override
    public String toString() {
        String resultado = "";
        for(int i=0 ; i < this.index; i++){
            resultado = resultado + this.vec_solicitudes[i]+"\n";
        }
        return resultado;
    }
}

