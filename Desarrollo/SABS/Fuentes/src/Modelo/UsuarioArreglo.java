package Modelo;
/*Autor: JoshuaMLN*/
import java.io.Serializable;

public class UsuarioArreglo implements Serializable{
    private Usuario[] vec_usuarios;
    private int index, dimension;
    private final String[] encabezado =  {"USUARIO","CONTRASEÑA","ESTADO" };

    public UsuarioArreglo(int dimension) {
        this.vec_usuarios = new Usuario[dimension];
        this.dimension=dimension;
        this.index = 0;
    }
    
    public String[] getEncabezado() {
        return encabezado;
    }
    
    private boolean full() {
        if(this.index == this.vec_usuarios.length) 
            return true;
        else 
            return false;
    }
    
    private boolean vacio() {
        if(this.index == 0) 
            return true;
        else 
            return false;
    }
    
    public Object[][] getInfo(){
        Object resultado[][] = new Object[this.index][3];
        if(!vacio()){
            for(int i = 0; i< this.index;i++){
                resultado[i][0] = this.vec_usuarios[i].getUsuario();
                resultado[i][1] = this.vec_usuarios[i].getContrasena();
                resultado[i][2] = "ACTIVO";
            }
        }
        return resultado;
    }
    
    public Usuario[] getInfoCombo(){
        Usuario resultado[]= null;
        if(!vacio()){
            resultado = new Usuario[this.index];
            for(int i = 0; i<this.index; i++){
                resultado[i]= this.vec_usuarios[i];
            }
        }
        return resultado;
    }
    
    public boolean agregar(Usuario usuario){
        boolean resultado = false;
        if(!full()){
            this.vec_usuarios[index] = usuario;
            index++;
            resultado = true;
        }else{
            redimensionar();
        }
        return resultado;
    }
    
    public void redimensionar(){
        int new_dimension = this.dimension*3;
        Usuario[] nuevoArreglo = new Usuario[new_dimension];
        for(int i=0; i < this.index; i++){
            nuevoArreglo[i] = this.vec_usuarios[i];
        }
        this.vec_usuarios = nuevoArreglo;
    }
  
    public Usuario ingresar(String user, String password){
        Usuario resultado = null;
        for( Usuario tmp_user : this.vec_usuarios ){
            if(tmp_user != null && tmp_user.ingresar(user,password)){
                resultado = tmp_user;
                break;
            }
        }
        return resultado;
    }
}
