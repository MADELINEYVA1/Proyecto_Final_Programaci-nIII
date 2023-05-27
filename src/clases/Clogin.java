
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
   Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;
    private PreparedStatement PS;
    private ResultSet rs;

    public Clogin() throws SQLException {
        this.CN = con.conectar();
    }
       
 
   public ArrayList<Nodo_registro_empleado> login(String Nombre, int contraseña) throws SQLException{
        ArrayList<Nodo_registro_empleado> res= new ArrayList<>();
        try{
            PS = CN.prepareStatement("select * from registro where Nombre=? and contraseña=?");
            PS.setString(1, Nombre);
            PS.setInt(2, contraseña);
            rs=PS.executeQuery();
            
            while (rs.next()) {
                Nodo_registro_empleado nr = new Nodo_registro_empleado();
                nr.setDPI(rs.getInt("DPI"));
                nr.setNombre(rs.getString("Nombre"));
                nr.setApellido(rs.getString("Apellido"));
                nr.setedad(rs.getInt("Edad"));
                nr.setcontraseña(rs.getInt("Contraseña"));
                res.add(nr);
           
        }
        }catch (SQLException e){
                    if (res.isEmpty()){
                    System.out.println("Acceso Denegado");
                    }else{
                    System.out.println("Bienvenido");
                    }
                    }
   
        
        return res;
        
    }

   

  
}
