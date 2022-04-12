public class Cola {
    NodoCola inicio, fin;
    int tamanio;

    public Cola(){
        inicio = fin = null;
        tamanio = 0;
    }

    public boolean estaVacia(){
        return tamanio == 0;
    }

    public void insertar(int dato){
        NodoCola nuevo = new NodoCola(dato);
        if(estaVacia()){
            inicio = fin = nuevo;
        }else{
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamanio++;
    }

    public int quitar(){
        int temporal = inicio.dato;
        inicio = inicio.siguiente;
        tamanio--;
        return temporal;

    }

    public int inicioCola(){
        return inicio.dato;
    }
}
