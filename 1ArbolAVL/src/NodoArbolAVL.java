public class NodoArbolAVL{
    int dato;
    int fe; //Factor de equilibrio
    NodoArbolAVL hijoDerecho, hijoIzquierdo;

    public NodoArbolAVL(int d){
        this.dato = d;
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}