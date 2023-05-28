
package Nodos;

import java.util.Date;


public class Nodo_picking {
    
    //se declaran las variables
    int idpicking ;
    int nopedido;
    String producto;
    int cantidad;
    String estado;
    
    
    //los métodos getter y setter permiten acceder y 
    //modificar el valor de las variables desde fuera de la clase.
    public int getIdpicking() {
        return idpicking;
    }

    public void setIdpicking(int idpicking) {
        this.idpicking = idpicking;
    }

    public int getNopedido() {
        return nopedido;
    }

    public void setNopedido(int nopedido) {
        this.nopedido = nopedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setError(String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setMotivo(String motivo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
