public class Main {
    public static void main(String[] args) {
        Lista lista1 = new Lista();

        lista1.agregarAlInicio(5);
        lista1.agregarAlInicio(4);
        lista1.agregarAlInicio(3);
        lista1.agregarAlInicio(2);
        lista1.agregarAlInicio(1);
        lista1.agregarAlFinal(6);
        lista1.eliminar(1);
        System.out.println(lista1.buscarElemento(1));
        lista1.mostrarLista();
    }
}
