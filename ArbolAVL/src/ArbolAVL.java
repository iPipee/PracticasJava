public class ArbolAVL {
    private NodoArbolAVL raiz;

    public ArbolAVL(){
        raiz = null;
    }

    //Buscar Nodo
    public NodoArbolAVL buscar(int d, NodoArbolAVL r){
        if(raiz == null){
            return null;
        }else if(r.dato == d){
            return r;
        }else if(r.dato < d){
            return buscar(d, r.hijoDerecho);
        }else{
            return buscar(d, r.hijoIzquierdo);
        }
    }

    //Obtener el Factor de Equilibrio
    public int obtenerFE(NodoArbolAVL x){
        if(x == null){
            return -1;
        }else{
            return x.fe;
        }
    }

    //Rotacion simple Izquierda
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL r){
        NodoArbolAVL auxiliar = r.hijoIzquierdo;
        r.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = r;
        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho))+1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    //Rotacion Simple Derecha
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL r){
        NodoArbolAVL auxiliar = r.hijoDerecho;
        r.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = r;
        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho))+1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }

    //Rotacion Doble a la Derecha
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL r){
        NodoArbolAVL temporal;
        r.hijoIzquierdo = rotacionDerecha(r.hijoIzquierdo);
        temporal = rotacionIzquierda(r);
        return temporal;
    }

    //Rotacion Doble a la Izquierda
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL r){
        NodoArbolAVL temporal;
        r.hijoDerecho = rotacionIzquierda(r.hijoDerecho);
        temporal = rotacionDerecha(r);
        return temporal;
    }
}
