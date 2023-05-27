
package Nodos;


public class Nodo_control_stock {
    
    int idstock;
    String producto;
    int stockinicial;
    int entradas;
    int salidas;
    int valor;

    
    
    public int getIdstock() {
        return idstock;
    }

    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }
    
    
    public String getproducto(){
        return producto;
    }
    
    public void setproducto(String producto){
        this.producto = producto;
    }
    
    
    public int getStockinicial() {
        return stockinicial;
    }

    public void setStockinicial(int stockinicial) {
        this.stockinicial = stockinicial;
    }
    
    
    public int getEntradas() {
        return entradas;
    }

    public void setEntradas(int entradas) {
        this.entradas = entradas;
    }

    
    public int getSalidas() {
        return salidas;
    }

    public void setSalidas(int salidas) {
        this.salidas = salidas;
    }

    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int getStockActual() {
        return stockinicial + entradas - salidas;
    }

    public boolean quedaPocoStock(int umbral) {
        int stockActual = getStockActual();
        return stockActual > 0 && stockActual < umbral;
    }
    


}