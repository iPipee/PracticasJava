public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario(){
        raiz = null;
    }

    //Metodo para insertar un Nodo en el Arbol
    public void agregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d,nom);
        if(raiz == null){
            raiz = nuevo;
        }else{
            NodoArbol temporal = raiz;
            NodoArbol padre;
            while (true){
                padre = temporal;
                if(d < temporal.dato){
                    temporal = temporal.hijoIzquierdo;
                    if(temporal == null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }else{
                    temporal = temporal.hijoDerecho;
                    if(temporal == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public NodoArbol buscarNodo(ArbolBinario r, int dsearch){
        NodoArbol temporal = r.raiz;
        while(temporal.dato != dsearch ){
            if(dsearch < temporal.dato){
                temporal = temporal.hijoIzquierdo;
            }else{
                temporal = temporal.hijoDerecho;
            }
            if(temporal == null){
                return null;
            }
        }
        System.out.println(temporal);
        return temporal;
    }

    public boolean estaVacio(){
        return raiz == null;
    }

    public void inOrden(NodoArbol r){
        if(r != null){
            inOrden(r.hijoIzquierdo);
            System.out.println(r.dato);
            inOrden(r.hijoDerecho);
        }
    }

    public void preOrden(NodoArbol r){
        if(r != null){
            System.out.println(r.dato);
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }

    public void postOrden(NodoArbol r){
        if(r != null){
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.println(r.dato);
        }
    }

}
