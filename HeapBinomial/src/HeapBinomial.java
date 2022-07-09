public class HeapBinomial {
    //Puntero al primer arbol binomial de la cola
    NodoCB head;

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
        temp.head = new NodoCB(null,null,null, a, 0);
        head = BinomialHeapUnion(temp);
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

            }
        }
    } 
}
