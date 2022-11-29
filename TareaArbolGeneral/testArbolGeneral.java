import java.nio.file.Path;
import java.nio.file.Paths;

public class testArbolGeneral {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Path p = Paths.get("a");
        arbol.newNode(p, "a");
        arbol.newNode(p, "b");
        arbol.newNode(p, "d");
        p = Paths.get("a/b");
        arbol.newNode(p, "c");
        p = Paths.get("a/d");
        arbol.newNode(p, "e");
        p = Paths.get("a/d");
        arbol.newNode(p, "g");
        System.out.print("Impreso por anchura: ");
        arbol.porNivel(arbol.root);
        System.out.println("\npeso: " + arbol.peso(arbol.root));
        System.out.print("preorder Iterativo: ");
        arbol.preorderIterativo();
        System.out.println("\npath: " + arbol.Path("g"));
        arbol.Imprimir();
    }
}
