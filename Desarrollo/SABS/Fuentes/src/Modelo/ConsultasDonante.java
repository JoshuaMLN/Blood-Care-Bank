
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConsultasDonante extends ConexionBaseDatos{
    
    //registrar
    /*
    public List listar(){
        PreparedStatement ps=null;
        Connection con=conectar();
        ResultSet rs;
        
        List<Donante>datos=new ArrayList<>();
        String sql ="SELECT * FROM empleados";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Donante e= new Donante();
                e.setCodigo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setDNI(rs.getString(4));
                e.setTelefono(rs.getInt(5));
                e.setEspecialidad(rs.getString(6));
                e.setSueldo(rs.getFloat(7));
                datos.add(e);
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }        
        return datos;
        
    }
    */
    
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
    
    

    
}
