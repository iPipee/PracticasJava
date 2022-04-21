public class Nodo {
    public int dato;
    public Nodo siguiente;
    public int exponente;

    public Nodo(int d, int exp){
        this.dato = d;
        this.exponente = exp;
        this.siguiente = null;
    }

    public Nodo(){
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
