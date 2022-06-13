public class MinHeap{
    private int[] heap; //vector donde se guardan los datos
    private int size; //La cantidad de elementos en el heap

    //Constructor para crear el heap vacio
    public MinHeap(int sizeMaximo){
        this.size = 0;
        heap = new int[sizeMaximo];
    }

    //Constructor para crear el Heap a partir de un arreglo de numeros
    public MinHeap(int[] arr){
        this.size = arr.length;
        //Se recibe el arreglo y se asigna el heap
        heap = arr;
        //Se construye el Heap
        ConstruirHeap();
    }

    //Retorna la cantidad de elementos que tiene el MinHeap
    public int Size(){
        return size;
    }

    public void insertar(int dato){
        if(size == heap.length){
            throw new IllegalStateException("MinHeap está lleno!!");
        }else{
            int posActual = size;
            //Se insertará el elemento en el arreglo
            heap[posActual] = dato;
            //Incrementa el tamaño
            size++;

            while(heap[posActual] < heap[padre(posActual)]){
                Intercambiar(posActual, padre(posActual));
                posActual = padre(posActual);
            }
        }
    }

    public void ConstruirHeap(){
        for (int i = size/2; i >= 0; i--) {
            Amontonar(i, size-1);
        }
    }

    private void Amontonar(int i, int j){
        //Comprueba que el hijo izquierdo de la posición i sea un valor menor o igual a j
        if((hijoIzq(i) <= j)){
            //k almacena la posición del valor que tiene que subir
            int k;
            if(hijoDer(i) <= heap[hijoIzq(i)]){
                k = hijoDer(i);
            }else{
                k = hijoIzq(i);
            }
            //Revisar si es mayor se hace el intercambio para armar nuevamente el heap
            if(heap[i] > heap[k]){
                Intercambiar(k, j);
                Amontonar(k, j);
            }
        }
    }

    //Retorna el menor valor del MinHeap
    public int getMin(){
        return heap[0];
    }

    //Cambia el valor de la posición i del arreglo, por la de j
    private void Intercambiar(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //Dada la posición de un nodo, devuelve la posición de su nodo padre
    private int padre(int pos){
        return ((pos-1)/2);
    }

    //Dada la posición de un nodo, devuelve la posición de su hijo izquierdo
    private int hijoIzq(int pos){
        return ((2 * pos) + 1);
    }

    //Dada la posición de un nodo, devuelve la posición de su hijo derecho
    private int hijoDer(int pos){
        return ((2 * pos) + 2);
    }

    public void verArreglo(){
        System.out.println("-- Arreglo --");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i]+"|");
        }
        System.out.println("");
    }

    public void verArbol(){
        System.out.println("-- Arbol --");
        for (int i = 0; i < size/2; i++) {
            System.out.println("Padre: "+ heap[i] + " Hijo Izquierdo: "+ heap[2*i+1] + " Hijo Derecho: "+ heap[2*i+2]);
            System.out.println(" ");
            
        }
    }
}