
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_control_stock;
import Nodos.Nodo_picking;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;


public class C_picking {
     Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;

    public C_picking () throws SQLException {
        this.CN = con.conectar();
    }
    
    public ArrayList<Nodo_picking> registropicking(int idst, int pedido, String producto, int cantidad, String estado ) throws SQLException{
         ArrayList<Nodo_picking> cp = new ArrayList<>();
         
         try{
             PreparedStatement PS = CN.prepareStatement(" INSERT INTO picking ( idpicking, nopedido, producto, cantidadproducto, estadoproducto) values(?,?,?,?,?) ");
            
            PS.setInt(1, idst);
            PS.setInt(2, pedido);
            PS.setString(3, producto);
            PS.setInt(4, cantidad);
            PS.setString(5, estado);
            PS.executeUpdate();
            
            
            
        Nodo_picking np = new Nodo_picking();
        np.setIdpicking(idst);
        np.setNopedido(pedido);
        np.setProducto(producto);
        np.setCantidad(cantidad);
        np.setEstado(estado);
        cp.add(np);
        
        
 
        
               JOptionPane.showMessageDialog(null, "Picking guardado");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo guardar picking");       
        
        }
                        
           return cp;
    

        }
    
    
     public ArrayList<Nodo_picking> picking(String prod, int cantidad) throws SQLException {
    ArrayList<Nodo_picking> mensajes = new ArrayList<>();
    
    try {
        String queryVerificar = "SELECT cantidadproducto FROM picking WHERE producto = ?";
        PreparedStatement statementVerificar = CN.prepareStatement(queryVerificar);
        statementVerificar.setString(1, prod);
        ResultSet resultSet = statementVerificar.executeQuery();

        if (resultSet.next()) {
            int stockdisponible = resultSet.getInt("cantidadproducto");

            if (stockdisponible >= cantidad) {
                // Actualizar el stock disponible
                int nuevoStock = stockdisponible - cantidad;

                String queryActualizar = "UPDATE picking SET cantidadproducto = ? WHERE producto = ?";
                PreparedStatement statementActualizar = CN.prepareStatement(queryActualizar);
                statementActualizar.setInt(1, nuevoStock);
                statementActualizar.setString(2, prod);
                statementActualizar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Se retiraron " + cantidad + " unidades del picking con producto: " + prod);
            } else {
                JOptionPane.showMessageDialog(null,"No hay suficiente stock disponible para retirar la cantidad especificada");
            }
        } else {
            JOptionPane.showMessageDialog(null,"No se encontró un picking con el producto especificado");
        }
    } catch (SQLException ex) {
        // Agrega el mensaje de error a la lista
        JOptionPane.showMessageDialog(null,"No se pudo realizar el retiro del picking. Error: " + ex.getMessage());
    }
   
    return mensajes;
}
    
     
   public ArrayList<Nodo_picking> devolucion(int idst, String producto, int cantidad, Date fecha, String motivo) throws SQLException {
    ArrayList<Nodo_picking> mensajes = new ArrayList<>();
    
    try {
        // Obtener la fecha actual
        Date fechaActual = new Date();
        
        // Crear la consulta SQL para la devolución
        String queryDevolucion = "INSERT INTO devoluciones (iddevoluciones, producto, cantidad, fecha, motivo) VALUES (?, ?, ?, ?,?)";
        PreparedStatement statementDevolucion = CN.prepareStatement(queryDevolucion);
        statementDevolucion.setInt(1, idst);
        statementDevolucion.setString(2, producto);
        statementDevolucion.setInt(3, cantidad);
        statementDevolucion.setDate(4, new java.sql.Date(fechaActual.getTime())); // Convertir la fecha a java.sql.Date
        statementDevolucion.setString(5, motivo);
        statementDevolucion.executeUpdate();
        
         JOptionPane.showMessageDialog(null, "Se realizó la devolución de " + cantidad + " unidades del picking con producto " );

            // Agregar el mensaje de éxito a la lista
            Nodo_picking np = new Nodo_picking();
            np.setIdpicking(idst);
            np.setCantidad(cantidad);
            np.setFecha(fecha);
            np.setMotivo(motivo);
            mensajes.add(np);
        
        
        
    } catch (SQLException ex) {
        // Agrega el mensaje de error a la lista
        JOptionPane.showMessageDialog(null, "No se pudo realizar la devolución. Error: " + ex.getMessage());
    }
   
    return mensajes;
}

    

    
}
