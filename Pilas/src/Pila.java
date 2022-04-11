public class Pila {
    int vectorPila[];
    int cima;

    //Constructor
    public Pila(int tamanio){
        vectorPila = new int[tamanio];
        cima = -1;
    }

    //Empujar dato
    public void push(int dato){
        cima++;
        vectorPila[cima] = dato;
    }

    //Sacar y obtener dato
    public int pop(){
        int dato = -1;
        if(cima >= 0) {
            dato = vectorPila[cima];
            cima--;
        }
        return dato;
    }

    public boolean estaVacia(){
        return cima==-1;
    }

    //Metodo para saber si la lista esta llena
    public boolean estaLlena(){
        return cima == vectorPila.length-1;
    }

    public int cimaPila(){
        return vectorPila[cima];
    }

    public int tamanioPila(){
        return vectorPila.length;
    }
}
