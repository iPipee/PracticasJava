//Javier Soto, Felipe Toro y Jorge Jara


import java.nio.file.Path;
import java.nio.file.Paths;

public class testArbolGeneral {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Path p = Paths.get("a");
        arbol.newNode(p, "a");                      //a como raíz
        arbol.newNode(p, "b");                      //b como hijo de a
        arbol.newNode(p, "d");                      //d como hermano de b
        p = Paths.get("a/b");                     //Cambiar la ruta para setear a c, como hijo de b
        arbol.newNode(p, "c");
        p = Paths.get("a/d");
        arbol.newNode(p, "e");
        p = Paths.get("a/d");
        arbol.newNode(p, "g");
        System.out.print("Impreso por anchura: ");
        arbol.porNivel();
        System.out.println("\npeso: " + arbol.Peso());
        System.out.print("preorder Iterativo: ");
        arbol.preorderIterativo();
        System.out.println("\npath: " + arbol.Path("g"));
        System.out.println("Altura: " + arbol.Altura());
        arbol.Imprimir();
        arbol.Delete(Paths.get("/a/d/e"));
        arbol.Imprimir();

    }
}
