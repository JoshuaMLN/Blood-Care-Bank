
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class ConsultasDonante extends ConexionBaseDatos{
    
    public static DefaultTableModel listar(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Naci");
        modelo.addColumn("DNI");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM donante";
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
    
    public boolean registrarDonante(Donante donante){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("INSERT INTO donante(nombre_d,fecha_naci,dni_d,edad_d,telf_d,correo_d) VALUES (?,?,?,?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,donante.getNombre());
            ps.setString(2,donante.getFechaNac());//timestamp
            ps.setString(3,donante.getDNI());
            ps.setInt(4,donante.getEdad()); 
            ps.setString(5,donante.getTelefono());
            ps.setString(6,donante.getCorreo()); 
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
    
    public boolean eliminarDonante(int codDonante){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM donante WHERE id_donante=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codDonante); //
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
    
    public void comboDonante(DefaultComboBoxModel donantes){
        PreparedStatement ps=null;
        Connection con=conectar();
        ResultSet rs;
        String sql = ("SELECT nombre_d FROM donante");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                donantes.addElement(rs.getString("nombre_d"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    //Metodo para editar datos de un donante
    public void editaDonate(int idDon, Donante donante){
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE donante set nombre_d=?,fecha_naci=?,dni_d=?,edad_d=?,telf_d=?,correo_d=? WHERE id_donante=?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, donante.getNombre());
            ps.setString(2, donante.getFechaNac());
            ps.setString(3, donante.getDNI());
            ps.setInt(4, donante.getEdad());
            ps.setString(5, donante.getTelefono());
            ps.setString(6, donante.getCorreo());
            ps.setInt(7, idDon);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Método para buscar cliente
    public Donante buscar(int id){
        Connection con=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Donante d = new Donante();
        String sql = "select * from donante where id_donante=?";
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                d.setNombre(rs.getString(2));
                d.setFechaNac(rs.getString(3));
                d.setDNI(rs.getString(4));
                d.setEdad(rs.getInt(5));
                d.setTelefono(rs.getString(6));
                d.setCorreo(rs.getString(7));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return d;
    }
    
}
