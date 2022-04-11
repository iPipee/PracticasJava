public class ListaDoble {
    NodoDoble inicio, fin;

    public ListaDoble(){
        this.inicio = null;
        this.fin = null;
    }

    public boolean estaVacia(){
        return inicio == null;
    }

    public void agregarAlFinal(int dato){
        if(!estaVacia()){
            fin = new NodoDoble(fin,null, dato);
            fin.anterior.siguiente = fin;
        }else{
            inicio = fin = new NodoDoble(dato);
        }
    }

    public void agregarAlInicio(int dato){
        if(!estaVacia()){
            inicio = new NodoDoble(null,inicio, dato);
            inicio.siguiente.anterior = inicio;
        }else{
            inicio = fin = new NodoDoble(dato);
        }
    }

    //Metodo para mostrar la lista de inicio a fin
    public void mostrarLista(){
        if(!estaVacia()){
            NodoDoble temporal = inicio;
            while(temporal != null){
                System.out.print("<=> ["+temporal.dato + "] <=>");
                temporal =temporal.siguiente;
            }
        }
    }

    //Metodo para mostrar la lista de fin a inicio
    public void mostrarListaFinAInicio(){
        if(!estaVacia()){
            NodoDoble temporal = fin;
            while(temporal != null){
                System.out.println("<=> ["+temporal.dato + "] <=>");
                temporal =temporal.anterior;
            }
        }
    }

    public int eliminarDelInicio(){
        int elemento = inicio.dato;
        if(inicio == fin){
            inicio = fin =null;
        }else{
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return elemento;
    }

    public int eliminarDelFinal(){
        int elemento = fin.dato;
        if(inicio == fin){
            inicio = fin = null;
        }else{
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }
}
