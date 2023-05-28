
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_empleado;
import Nodos.Nodo_ubicacion;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Cubicacion {
   //creamos una instancia de la clase Conexion_BD
    Conexion_BD con = new Conexion_BD();
    
    //declaramos una variable CN de tipo java.sql.Connection
    java.sql.Connection CN;

    public Cubicacion() throws SQLException {
        this.CN = con.conectar();
    }
       
    public ArrayList<Nodo_ubicacion> registroubicacion(int idub, String prod, int est, int pas, int niv) throws SQLException{
         ArrayList<Nodo_ubicacion> ubi= new ArrayList<>();
         
         try{
             
             /*preparamos una consulta INSERT INTO con marcadores de  
             posición y creamos un objeto PreparedStatement*/
            PreparedStatement PS = CN.prepareStatement(" INSERT INTO ubicacion ( idubicacion, producto, estanteria, pasillo,  nivel) values(?,?,?,?,?) ");
            
            
        //proporcionamos los valores correspondientes a los marcadores de posición
            
            PS.setInt(1, idub);
            PS.setString(2, prod);
            PS.setInt(3, est);
            PS.setInt(4, pas);
            PS.setInt(5, niv);
            PS.executeUpdate();
            
            
        //creamos un nuevo objeto Nodo_ubicacion   
        Nodo_ubicacion nu = new Nodo_ubicacion();
        nu.setidubicacion(idub);
        nu.setproducto(prod);
        nu.setestanteria(est);
        nu.setpasillo(pas);
        nu.setnivel(niv);
        ubi.add(nu);
        
         /*mostramos cuadros de diálogos emergentes para mostrar un mensaje al usuario */
               JOptionPane.showMessageDialog(null, "Ubicacion Registrada");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo registrar Ubicacion");       
        
        }
        // finalizamos la ejecución del método y devolvemos la lista ubi                
           return ubi;
    

        }

   
        
    }
   
    

    
   
    
    
    
    
     

 
    
    
    

        
      
         
    
    

