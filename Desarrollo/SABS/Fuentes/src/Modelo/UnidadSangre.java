
package Modelo;


public class UnidadSangre {
    private float Volumen;
    private String GrupoSanguineo;
    private String Rh;
    
    //HOla 6
    public UnidadSangre(float Volumen, String GrupoSanguineo, String Rh) {
        this.Volumen = Volumen;
        this.GrupoSanguineo = GrupoSanguineo;
        this.Rh = Rh;
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

    
    
    
}


