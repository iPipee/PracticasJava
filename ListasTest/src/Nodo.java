public class Nodo {
    int dato;
    Nodo siguiente; // Puntero enlace

    //Constructor para insertar al final
    public Nodo(int dato){
        this.dato = dato;
        siguiente = null;
    }

    public Nodo(int d, Nodo n){
        dato = d;
        siguiente = n;
    }


    public Nodo getSiguiente() {
        return siguiente;
    }

}
