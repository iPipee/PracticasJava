public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregarNodo(1, "Maria");
        arbol.agregarNodo(2, "Jaime");
        arbol.agregarNodo(5, "Juanca");
        arbol.agregarNodo(3, " xd");
        arbol.inOrden(arbol.raiz);
        System.out.println(" ");
        arbol.preOrden(arbol.raiz);
        System.out.println(" ");
        arbol.postOrden(arbol.raiz);
        arbol.buscarNodo(arbol,5);
    }
}
