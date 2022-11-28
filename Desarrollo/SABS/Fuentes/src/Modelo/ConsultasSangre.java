
package Modelo;

import Datos.Repositorio;
import static Modelo.ConexionBaseDatos.conectar;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class ConsultasSangre extends ConexionBaseDatos{
    
    //Metodo que retorna una tabla con los datos de la Base de datos
    public static DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Volumen");
        modelo.addColumn("Grupo Sanguineo");
        modelo.addColumn("RH");
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM sangre";
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            while (rs.next()) {//llenar cada fila
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de listado: "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
            
        }
        return modelo;
    }

    
    //Metodo para saber cuanta sangre hay disponible
    public float verificaVolumen(int idSan){//id de la sangre
        float busqueda_vol=-100;
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionBaseDatos.conectar();
            String sentencia_buscar = ("SELECT vol_sangre FROM sangre WHERE id_sangre ='"+idSan+"'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_vol = rs.getFloat("vol_sangre");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_vol;
    }
    
    
    //Metodo para añadir volumen
    public void añadir(int idSan, float volAdicional){//persona/ id de la familia a colocar
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE sangre set vol_sangre=? WHERE id_sangre=?";
            ps = conexion.prepareStatement(sql);
            float nuevoValor= verificaVolumen(idSan)+volAdicional;
            ps.setFloat(1, nuevoValor);
            
            ps.setInt(2, idSan);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void disminuir(int idSan, float volMenos){//persona/ id de la familia a colocar
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE sangre set vol_sangre=? WHERE id_sangre=?";
            ps = conexion.prepareStatement(sql);
            float nuevoValor= verificaVolumen(idSan)-volMenos;
            ps.setFloat(1, nuevoValor);
            
            ps.setInt(2, idSan);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //metodo que trae el codigo de la sangre a partir de su tipo y RH
    public int idSangre(String grupo,String rh){//id de la sangre
        int busqueda_id=-100;//en caso dee error
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionBaseDatos.conectar();
            String sentencia_buscar = ("SELECT id_sangre FROM sangre WHERE grupo_sangre ='"+grupo+"' AND rh_sangre = '" + rh + "'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_id = rs.getInt("id_sangre");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
    
}
