public class Lista {
       private Nodo inicio, fin; // Punteros para saber donde esta el inicio y el fin

    public Lista(){
        inicio = null;
        fin = null;
    }

    //Metodo para agregar un nodo al inicio de la lista
    public void agregarAlInicio(int elemento){
        //Creando al nodo
        inicio = new Nodo(elemento, inicio);
        if(fin == null){
            fin = inicio;
        }
    }

    //Metodo para insertar al final de la lista
    public void agregarAlFinal(int elemento){
        if(!estaVacia()){
            fin.siguiente = new Nodo(elemento);
            fin = fin.siguiente;
        }else{
            inicio = new Nodo(elemento);
            fin = new Nodo(elemento);
        }
    }

    //Metodo para eliminar el nodo inicial de la lista
    public int borrarAlInicio(){
        int elemento = inicio.dato;
        if(inicio == fin){
            inicio = null;
            fin = null;
        }else{
            inicio = inicio.siguiente;
        }
        return elemento;
    }

    public int borrarAlFinal(){
        int elemento = fin.dato;
        if(inicio == fin){
            inicio = null;
            fin = null;
        }
        if(!estaVacia()){
            Nodo recorrer = inicio;
            while(recorrer.siguiente != fin){
                recorrer = recorrer.siguiente;
            }
            fin = recorrer;
            fin.siguiente = null;
        }
        return elemento;
    }

    public void eliminar(int elemento){
        if(!estaVacia()){
            if(inicio == fin && elemento == inicio.dato){
                inicio = null;
                fin = null;
            }else{
                if(elemento == inicio.dato){
                    inicio = inicio.siguiente;
                }else{
                    Nodo anterior = inicio;
                    Nodo temporal = inicio.siguiente;
                    while(temporal != null && temporal.dato != elemento){
                        anterior = anterior.siguiente;
                        temporal = temporal.siguiente;
                    }
                    if(temporal != null){
                        anterior.siguiente = temporal.siguiente;
                        if(temporal == fin){
                            fin = anterior;
                        }
                    }
                }
            }
        }
    }

    public boolean buscarElemento(int elemento){
        if(!estaVacia()){
            Nodo temporal = inicio;
            while(temporal != null && temporal.dato != elemento){
                temporal = temporal.siguiente;
            }
            if(temporal.dato == elemento){
                return true;
            }
        }
        return false;
    }

    //Metodo para saber si la lista esta vacia
    public boolean estaVacia(){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }

    //Metodo para mostrar los datos
    public void mostrarLista(){
        Nodo recorrer = inicio;
        while(recorrer != null){
            System.out.print("["+recorrer.dato+"]---->");
            recorrer = recorrer.siguiente;
        }
    }
}
