
package Modelo;


public class ExtraccionSangre {
    private static int contador=0;
    private int codigo;
    private String Fecha;
    private float Volumen;
    private String GrupoSanguineo;
    private String Rh;
    

    private Donante donante;

    public ExtraccionSangre(String Fecha, float Volumen, String GrupoSanguineo, String Rh, Donante donante) {
        this.codigo=contador;
        contador++;
        this.Fecha = Fecha;
        this.Volumen = Volumen;
        this.GrupoSanguineo = GrupoSanguineo;
        this.Rh = Rh;
        this.donante = donante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getVolumen() {
        return Volumen;
    }

    public void setVolumen(float Volumen) {
        this.Volumen = Volumen;
    }

    public String getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(String GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String Rh) {
        this.Rh = Rh;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }
    

    
    

}
