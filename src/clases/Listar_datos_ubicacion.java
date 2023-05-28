
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_empleado;
import Nodos.Nodo_ubicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Listar_datos_ubicacion {
    public static Object listarubicacion;
    
    //creamos una instancia de la clase Conexion_BD
   Conexion_BD con = new Conexion_BD();
   
   //declaramos una variable CN de tipo java.sql.Connection
    java.sql.Connection CN;
    
    //declaramos una variable PS de tipo PreparedStatement
    private PreparedStatement PS;
    //declaramos una variable llamada resultSet de tipo ResultSet
    private ResultSet rs;

    public Listar_datos_ubicacion () throws SQLException {
        this.CN = con.conectar();
    }
       
 
   public ArrayList<Nodo_ubicacion> listarubicacion(String producto) throws SQLException{
        ArrayList<Nodo_ubicacion> res= new ArrayList<>();
        try{
            
    
            PS = CN.prepareStatement("select * from ubicacion where producto = ?");
            PS.setString(1, producto);
            rs=PS.executeQuery();
            
            
            
            while (rs.next()) {
                
                /*creamos un nuevo objeto Nodo_ubicacion, establecemos sus atributos 
                utilizando los valores obtenidos del objeto ResultSet y luego se agrega
                este objeto a la lista res. */
                Nodo_ubicacion nu = new Nodo_ubicacion();
                nu.setidubicacion(rs.getInt("idubicacion"));
                nu.setproducto(rs.getString("Producto"));
                nu.setestanteria(rs.getInt("estanteria"));
                nu.setpasillo(rs.getInt("pasillo"));
                nu.setnivel(rs.getInt("nivel"));
                res.add(nu);
                
           
        }//mostramos mensajes en la consola dependiendo del resultado
            // de la consulta y si se produjo algún error.
        }catch (SQLException e){
                    if (res.isEmpty()){
                    System.out.println("producto no encontrado");
                    }else{
                    System.out.println("");
                    }
                    }
   
 // finalizamos la ejecución del método y devolvemos la lista res

        return res;
        
}
}

