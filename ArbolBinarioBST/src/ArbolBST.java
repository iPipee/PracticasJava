public class ArbolBST {
    public NodoArbol raiz;

    public ArbolBST(){
        raiz = null;
    }

    public void insertar(NodoArbol r, int dato){
        if(r == null){
            r = new NodoArbol(dato);
        }else{
            NodoArbol temporal = r;
            NodoArbol padre;
            while (true){
                padre = temporal;

                if(dato < temporal.dato){
                    temporal = temporal.hijoIzquierdo;
                    if(temporal == null){
                        padre.hijoIzquierdo = new NodoArbol(dato);
                        return;
                    }
                }else{
                    temporal = temporal.hijoDerecho;
                    if(temporal == null){
                        padre.hijoDerecho = new NodoArbol(dato);
                        return;
                    }
                }
            }
        }
    }

    public boolean buscarNodo(NodoArbol r, int dato){
        if(r== null) return false;
        boolean resul = false;
        NodoArbol temporal = r;

        while(true){
            if(dato < temporal.dato){
                temporal = temporal.hijoIzquierdo;
                if(temporal == null) resul= false;
                if(temporal.dato == dato) resul= true;
            }else{
                temporal = temporal.hijoDerecho;
                if(temporal == null) resul = false;
                if(temporal.dato == dato) resul = true;
            }
            System.out.println(resul);
        }
    }

    public boolean eliminar(NodoArbol r, int d){
        NodoArbol temporal = r;
        NodoArbol padre = r;

        boolean esHijoIzq = true;

        while(temporal.dato != d){
            padre = temporal;
            if(d < temporal.dato){
                esHijoIzq = true;
                temporal = temporal.hijoIzquierdo;
            }else{
                esHijoIzq = false;
                temporal = temporal.hijoDerecho;
            }
            if(temporal == null){
                return false;
            }
        }//Fin del while
        if(temporal.hijoIzquierdo == null && temporal.hijoDerecho == null){
            if(temporal == r){
                r = null;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = null;
            }else{
                padre.hijoDerecho = null;
            }
        }else if(temporal.hijoDerecho == null){
            if(temporal == r){
                r = temporal.hijoIzquierdo;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = temporal.hijoIzquierdo;
            }else{
                padre.hijoDerecho = temporal.hijoIzquierdo;
            }
        }else if(temporal.hijoIzquierdo == null){
            if(temporal == r){
                r = temporal.hijoDerecho;
            }else if(esHijoIzq){
                padre.hijoDerecho = temporal.hijoDerecho;
            }else{
                padre.hijoIzquierdo = temporal.hijoDerecho;
            }
        }else{
            NodoArbol reemplazo = obtenerNodoReemplazo(temporal);
            if(temporal == r){
                r = reemplazo;
            }else if(esHijoIzq){
                padre.hijoIzquierdo = reemplazo;
            }else{
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = temporal.hijoIzquierdo;
        }
        return true;
    }

    //Metodo encargado de devolvernos el nodo Reemplazo
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp){
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol temporal = nodoReemp.hijoDerecho;
        while(temporal != null){
            reemplazarPadre = reemplazo;
            reemplazo = temporal;
            temporal = temporal.hijoIzquierdo;
        }
        if(reemplazo != nodoReemp.hijoDerecho){
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es: "+reemplazo);
        return reemplazo;
    }

    public void inOrden(NodoArbol r){
        if(r == null) return;
        inOrden(r.hijoIzquierdo);
        System.out.println(r.dato);
        inOrden(r.hijoDerecho);
    }
}
