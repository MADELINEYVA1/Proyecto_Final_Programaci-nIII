
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_empleado;
import Nodos.Nodo_ubicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Clogin {

    public static Object registroempleado;
    
    /*creamos una instancia de la clase Conexion_BD, esta instancia 
    se almacena en la variable con*/
   Conexion_BD con = new Conexion_BD();
   
   //declaramos una variable CN de tipo java.sql.Connection
    java.sql.Connection CN;
    //declaramos una variable PS de tipo PreparedStatement
    private PreparedStatement PS;
    
    //declaramos una variable rs de tipo ResultSet, 
//para poder almacenar los resultados de una consulta a la base de datos.
    private ResultSet rs;

    public Clogin() throws SQLException {
        this.CN = con.conectar();
    }
       
 
   public ArrayList<Nodo_registro_empleado> login(String Nombre, int contraseña) throws SQLException{
        ArrayList<Nodo_registro_empleado> res= new ArrayList<>();
        try{
            
          /*creamos una consulta preparada que selecciona todas las columnas de la tabla "registro" donde el campo "Nombre" 
            es igual al primer parámetro proporcionado y el campo "contraseña" es 
            igual al segundo parámetro proporcionado. */   
            PS = CN.prepareStatement("select * from registro where Nombre=? and contraseña=?");  
            
          /*asignamos los valores de las variables Nombre y contraseña a los marcadores de posición 
            de la consulta preparada para luego ejecutar la consulta en la base de datos */  
            
            PS.setString(1, Nombre);
            PS.setInt(2, contraseña);
            rs=PS.executeQuery();
            
            while (rs.next()) {
                
            /*creamos un nuevo objeto Nodo_registro_empleado, establecemos sus atributos 
                utilizando los valores obtenidos del objeto ResultSet y luego se agrega
                este objeto a la lista res. */    
                
                Nodo_registro_empleado nr = new Nodo_registro_empleado();
                nr.setDPI(rs.getInt("DPI"));
                nr.setNombre(rs.getString("Nombre"));
                nr.setApellido(rs.getString("Apellido"));
                nr.setedad(rs.getInt("Edad"));
                nr.setcontraseña(rs.getInt("Contraseña"));
                res.add(nr);
           
        }
            
            //mostramos mensajes en la consola dependiendo del resultado
            // de la consulta y si se produjo algún error.
        }catch (SQLException e){
                    if (res.isEmpty()){
                    System.out.println("Acceso Denegado");
                    }else{
                    System.out.println("Bienvenido");
                    }
                    }
   
        // finalizamos la ejecución del método y devolvemos la lista res
        return res;
        
    }

   

  
}
