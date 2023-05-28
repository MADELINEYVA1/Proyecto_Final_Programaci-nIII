
package Nodos;


public class Nodo_calcular_stock {
    
    
     int stockInicial;
     int cantidadEntrada;
     int cantidadSalida;

    public Nodo_calcular_stock(int stockInicial) {
        this.stockInicial = stockInicial;
        this.cantidadEntrada = 0;
        this.cantidadSalida = 0;
    }

    public void registrarEntrada(int cantidad) {
        this.cantidadEntrada += cantidad;
    }

    public void registrarSalida(int cantidad) {
        this.cantidadSalida += cantidad;
    }

    public int getStockActual() {
        return stockInicial + cantidadEntrada - cantidadSalida;
    }

    public boolean quedaPocoStock(int umbral) {
        int stockActual = getStockActual();
        return stockActual > 0 && stockActual < umbral;
    }



}
