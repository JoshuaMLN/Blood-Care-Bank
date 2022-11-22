
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ConsultasExtraccion extends ConexionBaseDatos{
    
    public static DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Fecha");
        //modelo.addColumn("Donante");
        modelo.addColumn("Volumen");
        modelo.addColumn("Grupo");
        modelo.addColumn("RH");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM extracsangre";
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
                modelo.addRow(filas);//llenamos filas
            }
            
        } catch (SQLException e) {
            System.out.println("Error de listado: "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
            
        }
        return modelo;
    }
    
    public boolean registrarExtraccion(ExtraccionSangre ext){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("INSERT INTO extracsangre(fecha_extrac,vol_extrac,grupo_extrac,rh_extrac) VALUES (?,?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,ext.getFecha());
            ps.setFloat(2,ext.getVolumen());
            ps.setString(3,ext.getGrupoSanguineo());
            ps.setString(4,ext.getRh()); 
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarExtraccion(int codExtraccion){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM extracsangre WHERE id_extrac=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codExtraccion); //
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    

    
}
