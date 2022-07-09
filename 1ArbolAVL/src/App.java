public class App {
    public static void main(String[] args) throws Exception {
        ArbolAVL a = new ArbolAVL();
        a.insertar(10);
        a.insertar(5);
        a.insertar(13);
        a.insertar(1);
        a.insertar(6);
        a.insertar(17);
        a.inOrden(a.obtenerRaiz());
    }
}
