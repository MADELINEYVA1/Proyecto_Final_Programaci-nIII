/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Conexion_BD.Conexion_BD;
import Nodos.Nodo_registro_empleado;
import Nodos.Nodo_ubicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Windows 11
 */
public class Listar_datos_ubicacion {
    public static Object listarubicacion;
   Conexion_BD con = new Conexion_BD();
    java.sql.Connection CN;
    private PreparedStatement PS;
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
                Nodo_ubicacion nu = new Nodo_ubicacion();
                nu.setidubicacion(rs.getInt("idubicacion"));
                nu.setproducto(rs.getString("Producto"));
                nu.setestanteria(rs.getInt("estanteria"));
                nu.setpasillo(rs.getInt("pasillo"));
                nu.setnivel(rs.getInt("nivel"));
                res.add(nu);
                
           
        }
        }catch (SQLException e){
                    if (res.isEmpty()){
                    System.out.println("producto no encontrado");
                    }else{
                    System.out.println("");
                    }
                    }
   
        
        return res;
        
}
}

