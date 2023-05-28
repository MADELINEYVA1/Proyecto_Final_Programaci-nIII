
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
    //creamos una instancia de la clase Conexion_BD
   Conexion_BD con = new Conexion_BD();
   //declaramos una variable CN de tipo java.sql.Connection
    java.sql.Connection CN;
    //declaramos una variable PS de tipo PreparedStatement
    private PreparedStatement PS;
    //declaramos una variable llamada resultSet de tipo ResultSet
    private ResultSet rs;

    public registro_empleado () throws SQLException {
        this.CN = con.conectar();
    }
       
     public ArrayList<Nodo_registro_empleado> registroempleado(int dpi, String nom, String ap, int ed, int con) throws SQLException{
         ArrayList<Nodo_registro_empleado> res= new ArrayList<>();
         
         try{
             
            /*preparamos una consulta INSERT INTO con marcadores de  
             posición y creamos un objeto PreparedStatement*/ 
            PS = CN.prepareStatement(" INSERT INTO registro ( DPI, Nombre, Apellido, edad,  contraseña) values(?,?,?,?,?) ");
            //proporcionamos los valores correspondientes a los marcadores de posición
            PS.setInt(1, dpi);
            PS.setString(2, nom);
            PS.setString(3, ap);
            PS.setInt(4, ed);
            PS.setInt(5, con);
            PS.executeUpdate();
            
            
        //creamos un nuevo objeto Nodo_registro_empleado   
        Nodo_registro_empleado nr = new Nodo_registro_empleado();
        nr.setDPI(dpi);
        nr.setNombre(nom);
        nr.setApellido(ap);
        nr.setedad(ed);
        nr.setcontraseña(con);
        res.add(nr);
    
        
        /*mostramos cuadros de diálogos emergentes para mostrar un mensaje al usuario */
               JOptionPane.showMessageDialog(null, "Empleado Registrado");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo registrar empleado");       
        
        }
           
    // finalizamos la ejecución del método y devolvemos la lista res      
           return res;
    

        }
         
    }

