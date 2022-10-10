
package Metodos_SQL;
import static java.lang.Integer.getInteger;
import java.sql.*;
import javax.swing.JOptionPane;

public class Metodos_sql {
    
    
    public static ConexionBaseDatos conexion = new ConexionBaseDatos();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero;
    private String titulo;
    
    //Guardar usuario
    public int guardar(String nombre,String apellido,String usuario,String contraseña){
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO usuarios(nombre,apellido,usuario,contraseña) VALUES (?,?,?,?)");
        
        try {
            conexion = ConexionBaseDatos.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellido);
            sentencia_preparada.setString(3, usuario);
            sentencia_preparada.setString(4, contraseña);            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }
    
    //TRAER EL USUARIO(nombre y apellido)
    public static String buscarUsuario(String usuario){
        String busqueda_usuario = null;
        
        Connection conexion = null;
        try {
            conexion = ConexionBaseDatos.conectar();
            String sentencia_buscar = ("SELECT nombre, apellido FROM usuarios WHERE usuario ='"+usuario+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //validadmos y traemos el resultado
            if(resultado.next()){
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                
                busqueda_usuario = (nombre+" "+apellido);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;
    }
    
    //Retorna el id del usuario que se logeo
    public static String buscarId(String usuario){
        String busqueda_id = null;//para el id
        
        Connection conexion = null;
        try {
            conexion = ConexionBaseDatos.conectar();
            //String sentencia_buscar = ("SELECT nombre, apellido FROM usuarios WHERE usuario ='"+usuario+"'");
            String sentencia_buscar = ("SELECT id, nombre, apellido FROM usuarios WHERE usuario ='"+usuario+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            //validadmos y traemos el resultado
            if(resultado.next()){
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String id = resultado.getString("id");//IDDDDDDDD
                
                busqueda_id = (id);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
    
    //VERIFICAR SI EL USUARIO esta registrado o no
    public static String BuscarUsuarioRegistrado(String usuario, String contraseña){
        String busqueda_uRegistrado =  null;
        Connection conexion = null;
        
        try {
            conexion = ConexionBaseDatos.conectar();
            String sentencia_busqueda_uRegistrado = ("SELECT nombre,usuario,contraseña FROM usuarios WHERE usuario = '"+usuario+"' && contraseña = '"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_busqueda_uRegistrado);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                busqueda_uRegistrado = "Usuario registrado";
            }else{
                busqueda_uRegistrado = "Usuario NO registrado";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_uRegistrado;
    }
    
    //TAREAS
    //Guardar tareas 
    public int guardarTarea(String titulo,String descripcion,Date fecha, String hora, int prioridad, String estado, int idUsuario){
        int resultado = 0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO tareas(titulo,descri,fecha,hora,prioridad,estado,id_usuario) VALUES (?,?,?,?,?,?,?)");
        
        try {
            conexion = ConexionBaseDatos.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            
            sentencia_preparada.setString(1, titulo);
            sentencia_preparada.setString(2, descripcion);
            sentencia_preparada.setDate(3, fecha);
            sentencia_preparada.setString(4, hora);//setTime
            sentencia_preparada.setInt(5, prioridad); 
            sentencia_preparada.setString(6, estado); 
            sentencia_preparada.setInt(7, idUsuario); 
            
            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }  
    
    //metodo integer necesario para la validacion de la hora
    public int getInteger(String valor) {
        int integer = Integer.parseInt(valor);
        return integer;
    }
    
    //metodo que valida la hora
    public boolean validarHora(String hora) {
        boolean b;
        char[] a = hora.toCharArray();
        String[] c = hora.split(":");
        if ((a[0] == ' ') || (a[1] == ' ') || (a[2] == ' ') || (a[3] == ' ') ||(a[4] == ' ')||(a[5] == ' ')||(a[6] == ' ') || (getInteger(c[0]) > 23) || (getInteger(c[1]) > 59)||(getInteger(c[2])>59)) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }
    
   /*
    public void delete(int prioridad){
        Connection conexion = null;
        int resultado=0;
        String sql="delete from tareas where prioridad="+prioridad;
        try{
            conexion = ConexionBaseDatos.conectar();
            sentencia_preparada = conexion.prepareStatement(sql);
            resultado = sentencia_preparada.executeUpdate();
        }catch(Exception e ){
            System.out.println(e);
        }
    }*/
    
    public void delete(String titulo){
        Connection conexion = null;
        int resultado=0;
        String sql="delete from tareas where titulo='"+titulo+"'";
        try{
            conexion = ConexionBaseDatos.conectar();
            sentencia_preparada = conexion.prepareStatement(sql);
            resultado = sentencia_preparada.executeUpdate();
        }catch(Exception e ){
            System.out.println(e);
        }
    }
    
    public int existeUsuario(String usuario){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionBaseDatos.conectar();
        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs=ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
    
    public int existeTarea(String titulo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionBaseDatos.conectar();
        String sql = "SELECT count(id_tarea) FROM tareas WHERE titulo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, titulo);
            rs=ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
    
    
   
    
}
