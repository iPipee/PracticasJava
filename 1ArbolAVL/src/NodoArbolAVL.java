public class NodoArbolAVL{
    int dato;
    int fe; //Factor de equilibrio, es positivo si esta cargado a la derecha, negativo a la izquierda
    //el fe se calcula los nodos derechos - los nodos izquierdos, si la diferencia es de 1 o -1
    //no se debe rotar, pero si es una diferencia mayor a 1 o menor a -1, si debemos equilibrarlo
    //si la diferencia de un nodo es mayor a 1, y tiene un hijo derecho con diferencia -1, debemos realizar
    //una rotacion doble a la derecha.
    //si la deferencia de un nodo es mayor que -1, y su hijo izquierdo tiene distinto signo (+)
    //hacemos rotacion doble a la izquierda.
    NodoArbolAVL hijoDerecho, hijoIzquierdo;

    public NodoArbolAVL(int d){
        this.dato = d;
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}