
package Metodos_SQL;


import java.sql.*;


public class ConexionBaseDatos {
    

    //a
    public static String url = "jdbc:mysql://localhost/rememberme";
    public static String usuario = "root";
    public static String contraseña = "breakfast13?";
    public static String clase = "com.mysql.cj.jdbc.Driver";//antes com.mysql.jdbc.Driver
    
    
    public static Connection conectar(){
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection)DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conexion lograda");
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
}
