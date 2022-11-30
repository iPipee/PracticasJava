//Javier Soto, Felipe Toro y Jorge Jara


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.nio.file.*;

public class Arbol {
    public NodoArbol root;

    public Arbol() {
        root = null;
    }

    public static class NodoArbol {
        String nombre; // Objeto
        NodoArbol hijo; // HijoIzquierdo
        NodoArbol hermano; //HermanoDerecho

        NodoArbol(String elNombre, NodoArbol elHijo, NodoArbol elHermano) {
            nombre = elNombre;
            hijo = elHijo;
            hermano = elHermano;
        }
    }

    //Metodos para añadir nodos
    public boolean newNode(Path p, String n){
        if(root == null){
            root = new NodoArbol(n, null, null);
            return true;
        }else{
            NodoArbol tmp = findNodo(p.toString().replace("\\", "/"));
            if(tmp == null){
                return false;
            }else{
                return addHijo(tmp, n);
            }
        }
    }


    private NodoArbol findNodo(String elPath) {
        NodoArbol tmp1 = root;
        NodoArbol tmp2 = tmp1;

        StringTokenizer path = new StringTokenizer(elPath, "/");
        String token;
        while (path.hasMoreTokens()) {
            token = path.nextToken();
            while (tmp1 != null) {
                if (token.equalsIgnoreCase((String) tmp1.nombre)) {
                    break;
                } else {
                    tmp1 = tmp1.hermano;
                    tmp2 = tmp1;
                }
            }
            if (tmp1 == null) {
                return tmp1;
            }else {
                tmp2 = tmp1;
                tmp1 = tmp1.hijo;
            }
        }
        return tmp2;
    }

    private boolean addHijo(NodoArbol elPadre, String elDato) {
        NodoArbol tmp = elPadre.hijo;
        if (tmp == null) {
            elPadre.hijo = new NodoArbol(elDato, null, null);
            return true;
        }else {
            if(tmp.hermano == null){
                tmp.hermano = new NodoArbol(elDato, null, null);
            }else {
                NodoArbol hermanoTmp = tmp.hermano;
                while(hermanoTmp.hermano != null){
                    hermanoTmp = hermanoTmp.hermano;
                }
                hermanoTmp.hermano = new NodoArbol(elDato, null, null);
            }

            return true;
        }
    }


    //Metodo para deletear
    public void Delete(Path p){
        NodoArbol temp = findNodo(p.toString().replace("\\", "/"));         //devuelve el nodo hoja, que se quiere eliminar
        String path = p.toString();
        Path path2 = Paths.get(Path(String.valueOf(path.charAt(path.length()-3))));         //devuelve el path, el padre de la hoja que se quiere eliminar
        NodoArbol papa = findNodo(path2.toString().replace("\\", "/"));     //devuelve el nodo del padre.
        if (papa.hijo.nombre.equals(temp.nombre)){                                           //si el nodo que se busca, es hijo directo
            papa.hijo = null;                                                                //del padre, que se elimine
        }
        NodoArbol aux = papa.hijo;
        while(aux != null){                                                  //si no es hijo directo, que recorra los hermanos
            if (aux.hermano.nombre.equals(temp.nombre)){                     //si el hermano del hermano es igual al nodo que se busca
                aux.hermano = null;                                          //se setea como null, y termina la ejecucion, eliminando el nodo
                break;
            }
            aux = aux.hermano;
        }
    }


    //Metodos para calcular altura
    public int Altura(){
        return Depth(this.root);
    }

    private int Depth(NodoArbol n) {
        int hi = -1;
        int hd = -1;
        if (n.hijo != null) {
            hi = Depth(n.hijo);
        }
        if (n.hermano != null) {
            hd = Depth(n.hermano) - 1;
        }
        return 1 + Math.max(hi, hd);
    }


    //Metodos para imprimir el arbol
    void Imprimir() {
        System.out.println("--------------------------");
        imprime(root," ");
        System.out.println("--------------------------");
    }

    private void imprime(NodoArbol r, String tab)
    {
        if (r!=null)
        { System.out.println(tab + r.nombre);
            imprime(r.hijo, tab +"  ");
            imprime(r.hermano,tab);
        }
    }



    //Metodo preorderIterativo
    public void preorderIterativo() {
        if (root == null) {
            return;
        }
        Stack<NodoArbol> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty())
        {
            NodoArbol temp = stack.pop();
            System.out.print(temp.nombre + " ");
            if (temp.hermano!= null) {
                stack.push(temp.hermano);
            }
            if (temp.hijo != null) {
                stack.push(temp.hijo);
            }
        }
    }



    //Metodos para imprimir por nivel
    public void porNivel() {
        int level = 1;
        while (printLevel(root, level)) {
            level++;
        }
    }

    public static boolean printLevel(NodoArbol root, int level)
    {
        if (root == null) {
            return false;
        }
        if (level == 1)
        {
            System.out.print(root.nombre + "-");
            return true;
        }
        boolean right = printLevel(root.hermano, level - 1);
        boolean left = printLevel(root.hijo, level - 1);
        return left || right;
    }

    //Metodo calcular peso
    public int Peso(){
        return size(root);
    }

    private int size(NodoArbol n) {
        if (n ==null){
            return 0;
        }
        else{
            return 1 + (size(n.hijo) + size(n.hermano));
        }
    }


    //Intento de encontrar Path
    public String Path(String o){
        String path = "";
        ArrayList<String> list = new ArrayList<>();
        findPath(this.root, o, list);
        for (int i = 0; i < list.size(); i++) {
            path = path + "/" + list.get(i);
        }
        return path;
    }

    private boolean findPath(NodoArbol root, String k, ArrayList<String> list){
        if(root==null){
            return false;
        }
        list.add(root.nombre);
        if(root.nombre.equals(k)){
            return true;
        }
        if(findPath(root.hijo,k,list)){
            return true;
        }
        list.remove(list.size()-1);
        if (findPath(root.hermano,k,list)){
            return true;
        }
        return false;
    }

    //Recorridos
    public void preOrder(NodoArbol n, List<NodoArbol> list){
        if(n != null){
            list.add(root);
            preOrder(n.hijo, list);
            preOrder(n.hermano, list);
        }
    }

    public void inOrder(NodoArbol n, List<NodoArbol> list){
        if (n != null){
            inOrder(n.hijo, list);
            list.add(n);
            if(n.hijo != null){
                NodoArbol t = n.hijo.hermano;
                while (t != null){
                    inOrder(t, list);
                    t = t.hermano;
                }
            }
        }
    }

}