
package Conexion_BD;

import Nodos.Nodo_registro_empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conexion_BD {

    private static final String DRIVER      = "com.mysql.cj.jdbc.Driver";
    private static final String USER        = "root";
    private static final String PASSWORD    = "xxxxx";
    private static final String URL         = "jdbc:mysql://127.0.0.1:3306/bd_lacteos?user=root";

    private PreparedStatement PS ;
    private Connection CN;
    private Connection getConnetion;
    ResultSet rs;
    
   public Conexion_BD (){
       CN = null;
       PS = null;
        
    }

// ESTABLECEMOS CONEXION CON LA BASE DE DATOS
    public Connection conectar() throws SQLException{
        try{
            Class.forName(DRIVER);
            CN = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            
    
        } catch (ClassNotFoundException | SQLException ex){
            System.err.println("No se hizo la conexion");
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE HIZO LA CONEXIÓN A LA BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
    
    public static void main (String[] args) throws SQLException{
            Conexion_BD cx = new Conexion_BD();
           cx.conectar();
        
        }
// CERRAR LA CONEXION
    public void close(){
        try{
            CN.close();
        }catch (SQLException ex){
            JOptionPane.showInputDialog(null, ex.getMessage(), "NO SE CERRO LA CONEXIÓN", JOptionPane.ERROR_MESSAGE);
        }
        
        
                
    }
    
    
   
    
    
    public Conexion_BD(String cecytem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PreparedStatement prepareStatement(String _insert_into_ubicacion__idubicacion_produ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

  
   
    
}
