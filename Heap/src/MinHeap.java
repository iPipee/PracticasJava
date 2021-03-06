public class MinHeap{
    private int[] heap;
    private int size;

    public MinHeap(int maxsize){
        this.size = 0;
        heap = new int[maxsize];
    }

    //Constructor para crear heap a partir de un arreglo de numeros
    public MinHeap(int[] arr){
        this.size = arr.length;
        //Se recibe el arreglo y se asigna al heap
        heap = arr;

        //Se construye el heap
        buildHeap();
    }

    public int size(){
        return size;
    }

    public void insert(int dato){
        if(size == heap.length){
            throw new IllegalStateException("Min-Heap lleno");
        }else{
            int posActual = size; //Se coloca size ya que es la primera posicion disponible, si es 2, estaria ocupado 0 y 1, por ende, ocupa el 2
            //Se inserta el elemento en el arreglo
            heap[posActual] = dato;
            //Incrementa el contador
            size++;

            while(heap[posActual] < heap[parent(posActual)]){
                intercambia(posActual, parent(posActual));
                posActual = parent(posActual);
            }
        }
    }

    public void buildHeap(){
        for(int i = size/2; i >= 0; i--){
            Heapify(1, size - 1);
        }
    }

    public void Heapify(int i, int j){
        //Comprueba que el hijo izq de la posicion de i sea un valor menor o igual a j
        if((leftChild(i)) <= j){
            int k;

            //Si el hijo der de i es menor que j significa que tiene que elegir el mayor de los dos
            if((rightChild(i)) <= j){
                //Se elige la pos que tiene el valor mayor
                if(heap[rightChild(i)] <= heap[leftChild(i)]){
                    k = rightChild(i);
                }else{
                    k = leftChild(i);
                }
            }else{//Significa que solo tiene hijo izquierdo
                k = leftChild(i);
            }
            //Revisa si es mayor, se hace el intercambio para armar nuevamente el min-heap
            if(heap[i] > heap[k]){
                intercambia(i, k);
                Heapify(k, j);
            }
        }
    }

    //Cambia el valor de la posicion i del arreglo, por la de j
    private void intercambia(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //Dada la posicion de un nodo, devuelve la posicion de su nodo padre
    private int parent(int pos){
        return ((pos - 1) / 2);
    }

    //Dada la posicion de un nodo, devuelve la posicion de su hijo izquierdo
    private int leftChild(int pos){
        return ((2 * pos) + 1);
    }

    //Dada la posicion de un nodo, devuelve la posicion de su hijo derecho
    private int rightChild(int pos){
        return ((2 * pos) + 2);
    }




}
