
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_prodterminado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Cregistro_prod {
    Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;

    public Cregistro_prod () throws SQLException {
        this.CN = con.conectar();
    }
       
    public ArrayList<Nodo_registro_prodterminado> registroprodterminado(int idprod, String prod, int cant, int lot) throws SQLException{
         ArrayList<Nodo_registro_prodterminado> ter = new ArrayList<>();
         
         try{
             PreparedStatement PS = CN.prepareStatement(" INSERT INTO productosterminados ( idproductosterminados, nombreproducto, cantidad, No.lote) values(?,?,?,?) ");
            
            PS.setInt(1, idprod);
            PS.setString(2, prod);
            PS.setInt(3, cant);
            PS.setInt(4, lot);
            PS.executeUpdate();
            
            
            
        Nodo_registro_prodterminado np = new Nodo_registro_prodterminado();
        np.setIdprodterminados(idprod);
        np.setNombreproducto(prod);
        np.setCantidad(cant);
        np.setNo_lote(lot);
        ter.add(np);
        
       
        
        
               JOptionPane.showMessageDialog(null, "Producto registrado");
                
            }    
      catch(SQLException e){
         JOptionPane.showMessageDialog(null, "No se pudo registrar producto");       
        
        }
                        
           return ter;
    

        }
   

   
    }
