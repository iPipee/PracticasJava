public class Main {
    public static void main(String[] args) {
        Pila pila1 = new Pila(5);
        pila1.push(0);
        pila1.push(1);
        pila1.push(2);
        pila1.push(3);
        pila1.push(4);
        System.out.println(pila1.pop());
        System.out.println(pila1.cimaPila());
    }
}
