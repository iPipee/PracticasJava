public class NodoDoble {
    NodoDoble anterior;
    NodoDoble siguiente;
    int dato;

    public NodoDoble(NodoDoble anterior, NodoDoble siguiente, int dato) {
        this.anterior = anterior;
        this.siguiente = siguiente;
        this.dato = dato;
    }

    public NodoDoble(int el){
        this(null,null, el);
    }
}
