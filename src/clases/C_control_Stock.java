
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_control_stock;
import frames.login;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class C_control_Stock {
    
    //creamos una instancia de la clase Conexion_BD, esta instancia 
    //se almacena en la variable con
     Conexion_BD con = new Conexion_BD();
     
     //declaramos una variable CN de tipo java.sql.Connection
     /*Esta variable se compromete para almacenar 
     la conexión a la base de datos una vez establecida.   */
    java.sql.Connection CN;
    
    
    /*declaramos una variable llamada resultSet de tipo ResultSet.
    El ResultSet es un objeto utilizado para almacenar y manipular 
    los resultados de una consulta a la base de datos. */
    private ResultSet resultSet;

    public C_control_Stock () throws SQLException {
        /*asignamos el resultado para llamar al método conectar()de la 
        instancia de la clase Conexion_BD a la variable CN. */
        this.CN = con.conectar();
    }
       /* declaramos e implementamos un método llamado registrostock
     que devuelve un ArrayList de objetos del tipo Nodo_control_stock  */
    
    public ArrayList<Nodo_control_stock> registrostock(int idst, String producto, int stocki, int entradas, int salidas, int valor ) throws SQLException{
         ArrayList<Nodo_control_stock> cs = new ArrayList<>();
         
         try{
             
             /*preparamos una consulta INSERT INTO con marcadores de  
             posición y creamos un objeto PreparedStatement que se apoya 
             posteriormente para ejecutar la consulta */
             PreparedStatement PS = CN.prepareStatement(" INSERT INTO stock ( idstock, producto, stock_inicial, entrada, salidas, valor) values(?,?,?,?,?,?) ");
            
             
             
       /*proporcionamos los valores correspondientes a los marcadores de posición
         en la consulta preparada para poder ejecutar la consulta en la base de datos.  */      
             
            PS.setInt(1, idst);
            PS.setString(2, producto);
            PS.setInt(3, stocki);
            PS.setInt(4, entradas);
            PS.setInt(5, salidas);
            PS.setInt(6, valor);
            
            
            /*declaramos executeUpdate para realizar la 
            inserción de un nuevo registro en la tabla stock */
            PS.executeUpdate();
            
            
        /*creamos un nuevo objeto Nodo_control_stock utilizando
            el constructor sin argumentos de la clase */    
        Nodo_control_stock nc = new Nodo_control_stock();
        nc.setIdstock(idst);
        nc.setStockinicial(stocki);
        nc.setproducto(producto);
        nc.setEntradas(entradas);
        nc.setSalidas(salidas);
        nc.setValor(valor);
        cs.add(nc);
        
        
 
        /*mostramos cuadros de diálogos emergentes para mostrar un mensaje al usuario */
               JOptionPane.showMessageDialog(null, "Producto registrado");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo registrar producto");       
        
        }
                        
           return cs;
    

        }
    
    public ArrayList<Nodo_control_stock> calcularstock(String prod) throws SQLException {
    ArrayList<Nodo_control_stock> cs = new ArrayList<>();

    try {
        
        /* seleccionamos los campos "entrada", "salidas" y "stock_inicial"
        de la tabla "stock" en la base de datos. */
        String query = "SELECT entrada, salidas, stock_inicial FROM stock WHERE producto = ?";
        
        
        /*ejecutamos la consulta preparada en la base de datos y almacenamos
        el resultado en un objeto resultSet. */
        PreparedStatement statement = CN.prepareStatement(query);
        statement.setString(1, prod);
        resultSet = statement.executeQuery();

        
        /*ejecutamos  while mientras haya más filas en el objeto resultSet */
        while (resultSet.next()) {
            Nodo_control_stock nc = new Nodo_control_stock();
            nc.setproducto(prod);
            
            
            /*extraemos los valores de las columnas "entrada", "salidas" y 
            "stock_inicial" de la fila actual del objeto resultSet y los 
            almacenamos en las variables correspondientes. */

            int entradas = resultSet.getInt("entrada");
            int salidas = resultSet.getInt("salidas");
            int stockinicial = resultSet.getInt("stock_inicial");

            // Calcular el stock actual
            int stockActual = stockinicial + entradas - salidas;
            nc.setStockinicial(stockActual);

            // Agregar el objeto Nodo_control_stock al ArrayList
            cs.add(nc);
        }
    } catch (SQLException ex) {
        
    }
        // finalizamos la ejecución del método y devolvemos la lista cs

    return cs;
}

}

    
