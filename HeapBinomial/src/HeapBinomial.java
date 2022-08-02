public class HeapBinomial {
    //Puntero al primer arbol binomial de la cola
    NodoCB head;
    int size;

    //Constructor
    public HeapBinomial(){
        head = null;
    }

    public HeapBinomial(NodoCB head){
        this.head = head;
    }

    //Inserción de un elemento en el HeapBinomial
    public void insert(int a){
        HeapBinomial temp = new HeapBinomial();
        temp.head = new NodoCB(null,null,null, a, (short) 0);
        head = BinomialHeapUnion(temp);
        size++;
    }

    public void print(){
        System.out.println("Heap Binomial: ");
        if(head != null){
            head.print(0);
        }
    }
    
    //Union (Fusion de dos colas binomiales)
    private NodoCB BinomialHeapUnion(HeapBinomial H2){
        HeapBinomial H = BinomialHeapMerge(this, H2);
        if(H.head == null){
            return null;
        }

        NodoCB anterior = null;
        NodoCB actual = H.head;
        NodoCB siguiente = actual.sibling;
        while(siguiente != null){
            if((actual.degree != siguiente.degree) || 
            (siguiente.sibling != null && siguiente.sibling.degree == actual.degree)){
                //Si los grados son diferentes se avanza
                anterior = actual;
                actual = siguiente;
            }else if(actual.key <= siguiente.key){//el valor de actual es menor al siguiente
                //enlaza los hermanos para no perderlos
                actual.sibling = siguiente.sibling;
                //actual se une con el siguiente
                siguiente.binomialLink(actual);
            }else{//El valor de siguiente es menor que actual
                //enlaza los hermanos para no perderlos
                if(anterior == null){
                    H.head = siguiente;
                }else{
                    anterior.sibling = siguiente;
                }
                //siguiente se une con actual
                actual.binomialLink(siguiente);
                //el actual ahora es el siguiente (evita duplicidad)
                actual = siguiente;
            }
            siguiente = actual.sibling;
        }
        return H.head;
    } 

    //Mezcla de dos colas binomiales. A partir de dos colas se obtiene una tercera que contiene
    //los arboles binomiales de las dos colas ordenados por k
    private HeapBinomial BinomialHeapMerge(HeapBinomial H1, HeapBinomial H2){
        NodoCB h1 = H1.head;
        NodoCB h2 = H2.head;
        if(h1 == null){
            return H2;
        }

        if(h2 == null){
            return H1;
        }

        HeapBinomial H = new HeapBinomial();
        NodoCB ini = null;
        NodoCB fin = null;
        while(h1 != null && h2 != null){
            if(h1.degree <= h2.degree){
                if(ini == null){
                    ini = fin = h1;
                }else{
                    fin.sibling = h1;
                    fin = h1;
                }
                h1 = h1.sibling;
            }else{
                if(ini == null){
                    ini = fin = h2;
                }else{
                    fin.sibling = h2;
                    fin = h2;
                }
                h2 = h2.sibling;
            }
        }

        //Si alguna de las dos colas se termina, se agrega la contraria como hermano
        if(h1 == null){
            fin.sibling = h2;
        }

        if(h2 == null){
            fin.sibling = h1;
        }

        H.head = ini;
        return H;
    }

    //Obtener el minimo
    public Integer binomialHeapMinimum(){
        if(head == null){
            return -1;
        }else{
            NodoCB current = head;
            int min = current.key;
            while(current != null){
                if(current.key < min){
                    min = current.key;
                }
                current = current.sibling;
            }
            return min;
        }
    }

}
