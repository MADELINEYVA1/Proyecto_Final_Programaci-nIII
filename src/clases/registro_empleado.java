
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class registro_empleado {
    
    public static Object registroempleado;
   Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;
    private PreparedStatement PS;
    private ResultSet rs;

    public registro_empleado () throws SQLException {
        this.CN = con.conectar();
    }
       
     public ArrayList<Nodo_registro_empleado> registroempleado(int dpi, String nom, String ap, int ed, int con) throws SQLException{
         ArrayList<Nodo_registro_empleado> res= new ArrayList<>();
         
         try{
            PS = CN.prepareStatement(" INSERT INTO registro ( DPI, Nombre, Apellido, edad,  contraseña) values(?,?,?,?,?) ");
            
            PS.setInt(1, dpi);
            PS.setString(2, nom);
            PS.setString(3, ap);
            PS.setInt(4, ed);
            PS.setInt(5, con);
            PS.executeUpdate();
            
            
            
        Nodo_registro_empleado nr = new Nodo_registro_empleado();
        nr.setDPI(dpi);
        nr.setNombre(nom);
        nr.setApellido(ap);
        nr.setedad(ed);
        nr.setcontraseña(con);
        res.add(nr);
    
               JOptionPane.showMessageDialog(null, "Empleado Registrado");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo registrar empleado");       
        
        }
                        
           return res;
    

        }
         
    }

