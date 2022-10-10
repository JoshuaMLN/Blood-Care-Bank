
package Logico;

import java.util.Date;


public class Tarea {
    /*
    private String titulo;
    private String descripcion;
    private String tipoActividad;
    private Calendar fechaActividad;
    private String prioridad;
    private ArrayList<Actividad> listaInmediata;
    private ArrayList<Actividad> listaMediana;
    private ArrayList<Actividad> listaBaja;    
    */
    
    private String titulo;
    private String descripcion;
    private String prioridad_tarea;
    private String proceso_tarea;//segun modelo kanbam
    private Date fecha_tarea;
    
    public Tarea(String titulo, String descripcion, String prioridad_tarea , String proceso_tarea, Date fecha_tarea) {
       this.descripcion= descripcion;
       this.titulo=titulo;
       this.prioridad_tarea=prioridad_tarea;
       this.proceso_tarea=proceso_tarea;
    }
    
    
    //private ArrayList<Tarea> lista;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad_tarea() {
        return prioridad_tarea;
    }

    public void setPrioridad_tarea(String prioridad_tarea) {
        this.prioridad_tarea = prioridad_tarea;
    }

    public String getProceso_tarea() {
        return proceso_tarea;
    }

    public void setProceso_tarea(String proceso_tarea) {
        this.proceso_tarea = proceso_tarea;
    }

    public Date getFecha_tarea() {
        return fecha_tarea;
    }

    public void setFecha_tarea(Date fecha_tarea) {
        this.fecha_tarea = fecha_tarea;
    }
}
