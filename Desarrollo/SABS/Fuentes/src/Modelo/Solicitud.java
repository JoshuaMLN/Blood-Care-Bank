
package Modelo;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Solicitud {
    private static int contador=0;
    private int Codigo;
    private String Nombre;
    private String Motivo;
    private String GrupoSanguineo;
    private String Rh;
    private float Cantidad;
    private Date Fecha;
    private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY HH:mm");

    
    public Solicitud(String Nombre,String Motivo,String GrupoSanguineo,String Rh,float Cantidad){
        this.Codigo = contador;
        contador++;
        this.Nombre=Nombre;
        this.Motivo=Motivo;
        this.GrupoSanguineo=GrupoSanguineo;
        this.Rh=Rh;
        this.Cantidad=Cantidad;
        this.Fecha=new Date();

    }
    public int getCodigo(){
        return Codigo;
    }
    public void setCodigo(int Codigo){
        this.Codigo=Codigo;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getMotivo(){
        return Motivo;
    }
    public void setMotivo(String Motivo){
        this.Motivo=Motivo;
    }
    public String getGrupoSanguineo(){
        return GrupoSanguineo;
    }
    public void setGrupoSanguineo(String GrupoSanguineo){
        this.GrupoSanguineo=GrupoSanguineo;
    }
    public String getRh(){
        return Rh;
    }
    public void setRh(String Rh){
        this.Rh=Rh;
    }
    public float getCantidad(){
        return Cantidad;
    }
    public void setCantidad(float Cantidad){
        this.Cantidad=Cantidad;
    }

    public String getFecha(){
        return sdf.format(Fecha);
    }
    public void setFecha(Date Fecha){
        this.Fecha=Fecha;
    }
    @Override
    public String toString() {
        return "Solicitud{" + "Codigo:" + Codigo +"Nombre:" + Nombre + ", Motivo:" + Motivo + ", Grupo Sanguineo:" + GrupoSanguineo+ ", Rh:" + Rh +", Cantidad(L):" + Cantidad + ", Fecha y hora:" + sdf.format(Fecha) + "\n"+ '}';
    }
}



