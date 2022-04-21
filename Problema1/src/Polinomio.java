public class Polinomio {
    private Nodo inicio, fin;

    public Polinomio(){
        this.inicio = null;
        this.fin = null;
    }

    public void agregarNodo(int elemento, int exponente){
        if(inicio == null){
                inicio = new Nodo(elemento, exponente);
        }else{
            Nodo temporal = inicio;
            while(temporal.siguiente != null){
                temporal = temporal.siguiente;
            }
            temporal.siguiente= new Nodo(elemento, exponente);
        }

        if(fin == null){
            fin = inicio;
        }
    }

    public void sumarPolinomios(Polinomio two){
        Nodo temp = inicio;
        Nodo temporal = inicio;
        Nodo temporal2 = two.inicio;
        Nodo temporal3 = new Nodo();
        int resultado = 0;

        while (temp != null){
            if(temporal.exponente < temporal2.exponente){
                if(temporal2.siguiente != null){
                    temporal2 = temporal2.siguiente;
                }
            }else {
                if (temporal2.exponente < temporal.exponente) {
                    if (temporal.siguiente != null) {
                        temporal = temporal.siguiente;
                    }
                }
            }
            if(temporal.exponente == temporal2.exponente){
                resultado = temporal.dato + temporal2.dato;
                if(temporal3 == null){
                    temporal3 = new Nodo(resultado, temporal.exponente);
                }else{
                    while(temporal3.siguiente != null){
                        temporal3 = temporal3.siguiente;
                    }
                    temporal3.siguiente = new Nodo(resultado, temporal.exponente);
                }
                if(fin == null){
                    fin = inicio;
                }
            }
            temp = temp.siguiente;
        }
        Nodo temporal4 = temporal3;
        while(temporal4 != null){
            System.out.println("El polinomio es: "+ temporal4.dato + " - " + temporal4.exponente);
            temporal4 = temporal4.siguiente;
        }

    }
    //5x4+3x2+4
    //6x7+3x5+2x4+8x6+4x3+2x2+2


    public  void mostrarLista(){
        Nodo temporal = inicio;

        while(temporal != null){
            System.out.println("El polinomio es: "+ temporal.dato + temporal.exponente);
            temporal = temporal.siguiente;
        }
    }


    public boolean estaVacia(){
        return inicio == null;
    }
}
