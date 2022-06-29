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
        auxiliar.hijoIzquierdo = r;
        r.fe = Math.max(obtenerFE(r.hijoIzquierdo), obtenerFE(r.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //Rotación doble derecha
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL r){
        NodoArbolAVL temporal;
        r.hijoIzquierdo = rotacionDerecha(r.hijoIzquierdo);
        temporal = rotacionIzquierda(r);
        return temporal;
    }

    //Rotación doble izquierda
    public NodoArbolAVL rotaciónDobleIzquierda(NodoArbolAVL r){
        NodoArbolAVL temporal;
        r.hijoDerecho = rotacionIzquierda(r.hijoDerecho);
        temporal = rotacionDerecha(r);
        return temporal;
    }

    //Método para insertar AVL
    public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
        NodoArbolAVL nuevoPadre = subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo == null){
                subAr.hijoIzquierdo = nuevo;
            }else{
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho) == 2)){
                    if(nuevo.dato < subAr.hijoIzquierdo.dato){
                        nuevoPadre = rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre = rotaciónDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.dato > subAr.dato){
            if(subAr.hijoDerecho == null){
                subAr.hijoDerecho = nuevo;
            }else{
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)){
                    if(nuevo.dato > subAr.hijoDerecho.dato){
                        nuevoPadre = rotacionDerecha(subAr);
                    }else{
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo duplicado");
        }
        //Actualizando la altura (factor de equilibrio)
        if((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)){
            subAr.fe = subAr.hijoDerecho.fe + 1;
        }else if((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null)){
            subAr.fe = subAr.hijoIzquierdo.fe + 1;
        }else{
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;
        }
        return nuevoPadre;
    }

    //Metodo para insertar
    public void insertar(int d){
        NodoArbolAVL nuevo = new NodoArbolAVL(d);
        if(raiz == null){
            raiz = nuevo;
        }else{
            raiz = insertarAVL(nuevo, raiz);
        }
    }

    //Recorridos (Mismos que arboles binarios - Inorden - PreOrden - postOrden)
}
