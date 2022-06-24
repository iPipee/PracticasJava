public class MontonMinimo {
    public static void main(String[] args) throws Exception {
        MinHeap minheap = new MinHeap(7);

        minheap.insertar(30);
        minheap.insertar(48);
        minheap.insertar(15);
        minheap.insertar(67);
        minheap.insertar(24);
        minheap.insertar(17);
        minheap.insertar(5);
        minheap.verArreglo();
        minheap.verArbol();
        System.out.println(minheap.Size());
    }
}
