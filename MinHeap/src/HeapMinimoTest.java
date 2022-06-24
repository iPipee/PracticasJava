public class HeapMinimoTest {
    private int[] heap;
    private int tamano;

    public HeapMinimoTest(int[] array){
        heap = array;
        this.tamano = array.length;
        //ConstruirArbol();
    }

    public HeapMinimoTest(int size){
        heap = new int[size];
        this.tamano = 0;
    }

    public void insertar(int dato){
        if(heap.length == tamano){
            System.out.println("Esta lleno");
            return;
        }else{
            int posActual = tamano;
            heap[posActual] = dato;

            while(heap[posActual] < heap[padre(posActual)]){
                intercambiar(heap[posActual], heap[padre(posActual)]);
                posActual = heap[padre(posActual)];
            }
        }
    }

    private void intercambiar(int i, int j){
        int temp = heap[i];
        heap[i] = j;
        heap[j] = temp;
    }

    private void Amontonar(int i, int j){
        if(HijoIzq(i) <= j){
            int k;
            if(HijoDer(i) <= heap[HijoIzq(i)]){
                k = HijoDer(i);
            }else{
                k = HijoIzq(i);
            }
            //Revisar si es mayor se hace el intercambio para armar nuevamente el heap
            if(heap[i] > heap[k]){
                intercambiar(k, j);
                Amontonar(k, j);
            }
        }
    }

    //Metodos para obtener los datos de padres e hijos
    private int padre(int pos){
        return ((pos - 1)/2);
    }

    private int HijoIzq(int pos){
        return ((2*pos)+1);
    }

    private int HijoDer(int pos){
        return ((2*pos)+2);
    }


    
    
}
