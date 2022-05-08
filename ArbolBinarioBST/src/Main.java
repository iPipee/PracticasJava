public class Main {
    public static void main(String[] args) {
        ArbolBST a = new ArbolBST();
        NodoArbol xd = new NodoArbol(3);

        a.insertar(xd, 12);
        a.insertar(xd, 7);
        a.insertar(xd, 9);
        a.insertar(xd, 1);

        a.inOrden(xd);
        System.out.println(" ");

        a.eliminar(xd, 9);
        a.inOrden(xd);
    }
}
