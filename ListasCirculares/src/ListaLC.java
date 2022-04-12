public class ListaLC {
    NodoLC ultimo;

    public ListaLC(){
        this.ultimo = null;
    }

    public boolean estaVacia(){
        return ultimo == null;
    }

    public ListaLC insertar(int elemento){
        NodoLC nuevo = new NodoLC(elemento);
        if(ultimo != null){
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        return this;
    }

    public boolean eliminar(int elemento){
        NodoLC actual;
        boolean encontrado = false;
        actual = ultimo;
        while(actual.siguiente != ultimo && encontrado == false){
            encontrado = (actual.siguiente.dato == elemento);
            if(encontrado == false){
                actual = actual.siguiente;
            }
        }
        encontrado = (actual.siguiente.dato == elemento);
        if(encontrado){
            NodoLC temporal = actual.siguiente;
            if (ultimo == ultimo.siguiente){
                ultimo = null;
            }else{
                if(temporal == ultimo){
                    ultimo = actual;
                }
                actual.siguiente = temporal.siguiente;
            }
            temporal = null;
        }
        return encontrado = true;
    }

    public void mostrarLista(){
        NodoLC temporal = ultimo.siguiente;
        do{
            System.out.println(temporal.dato);
            temporal = temporal.siguiente;
        }while(temporal != ultimo.siguiente);
    }
}
