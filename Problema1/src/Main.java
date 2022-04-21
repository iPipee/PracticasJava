public class Main {
    public static void main(String[] args) {
        Polinomio pol = new Polinomio();
        pol.agregarNodo(3,1);
        pol.agregarNodo(1,2);
        pol.agregarNodo(5,3);
        pol.agregarNodo(5,4);
        pol.mostrarLista();
        Polinomio pol2 = new Polinomio();
        pol2.agregarNodo(5,1);
        pol2.agregarNodo(6,2);
        pol2.agregarNodo(3,3);
        pol2.agregarNodo(3,4);

        pol.sumarPolinomios(pol2);
    }
}
