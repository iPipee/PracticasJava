public class ArbolAVL {
    private NodoArbolAVL raiz;

    public ArbolAVL(){
        this.raiz = null;
    }

    public NodoArbolAVL buscar(NodoArbolAVL r, int d){
        if(r == null){
            return null;
        }else if(r.dato == d){
            return r;
        }else if(r.dato < d){
            return buscar(r.hijoDerecho, d);
        }else{
            return buscar(r.hijoIzquierdo, d);
        }
    }

    //Obtener el factor de equilibrio
    public int obtenerFE(NodoArbolAVL r){
        if(r == null){
            return -1;
        }else{
            return r.fe;
        }
    }

    //Rotación simple izquierda
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL r){
        NodoArbolAVL auxiliar = r.hijoIzquierdo;
        r.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = r;
        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //Rotación simple derecha
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL r){
        NodoArbolAVL auxiliar = r.hijoDerecho;
        r.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoi = r;
        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }
}
