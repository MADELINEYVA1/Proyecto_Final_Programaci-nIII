
package Nodos;


public class Nodo_registro_empleado {
    //se declaran varibles
    private int DPI;
    private String Nombre;
    private String Apellido;
    private int edad;
    private int contraseña;

    
    //los métodos getter y setter permiten acceder y 
    //modificar el valor de las variables desde fuera de la clase.
    
    
    
    
   //getDPI es un método de acceso público que devuelve el 
    //valor actual de la variable DPI. En este caso, devuelve un entero.
    public int getDPI() {
        return DPI;
    }
    
    //setDPI es un método de modificación pública que establece el valor de 
    //la variable DPI con el valor proporcionado como argumento. 
    //En este caso, el argumento también es un entero.
    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getedad() {
        return edad;
    }

    public void setedad(int edad) {
        this.edad = edad;
    }

    public int getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(int contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
    
    
    
    
    
}
