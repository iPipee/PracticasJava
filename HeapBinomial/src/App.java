public class App {
    public static void main(String[] args) throws Exception {
        HeapBinomial b = new HeapBinomial();

        b.insert(2);
        b.insert(17);
        b.insert(12);
        b.insert(4);
        b.insert(7);
        b.insert(1);
        b.insert(10);
        b.insert(18);
        b.insert(21);
        b.insert(6);
        b.insert(15);
        b.insert(15);

        //Muestra la cola binomial por pantalla
        b.print();

        System.out.println("El valor minimo del heap binomial es: "+b.binomialHeapMinimum());
        

    }
}
