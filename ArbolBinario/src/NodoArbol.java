public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;

    public NodoArbol(int d, String nom){
        this.dato = d;
        this.nombre = nom;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public String toString(){
        return this.nombre + " Su dato es: " + this.dato;
    }

}
