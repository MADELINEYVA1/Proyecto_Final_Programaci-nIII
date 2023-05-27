
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
     Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;
    private ResultSet resultSet;

    public C_control_Stock () throws SQLException {
        this.CN = con.conectar();
    }
       
    public ArrayList<Nodo_control_stock> registrostock(int idst, String producto, int stocki, int entradas, int salidas, int valor ) throws SQLException{
         ArrayList<Nodo_control_stock> cs = new ArrayList<>();
         
         try{
             PreparedStatement PS = CN.prepareStatement(" INSERT INTO stock ( idstock, producto, stock_inicial, entrada, salidas, valor) values(?,?,?,?,?,?) ");
            
            PS.setInt(1, idst);
            PS.setString(2, producto);
            PS.setInt(3, stocki);
            PS.setInt(4, entradas);
            PS.setInt(5, salidas);
            PS.setInt(6, valor);
            PS.executeUpdate();
            
            
            
        Nodo_control_stock nc = new Nodo_control_stock();
        nc.setIdstock(idst);
        nc.setStockinicial(stocki);
        nc.setproducto(producto);
        nc.setEntradas(entradas);
        nc.setSalidas(salidas);
        nc.setValor(valor);
        cs.add(nc);
        
        
 
        
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
        String query = "SELECT entrada, salidas, stock_inicial FROM stock WHERE producto = ?";
        PreparedStatement statement = CN.prepareStatement(query);
        statement.setString(1, prod);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Nodo_control_stock nc = new Nodo_control_stock();
            nc.setproducto(prod);

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

    return cs;
}

}

    
