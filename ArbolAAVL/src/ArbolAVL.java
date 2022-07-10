public class ArbolAVL {
    NodoAVL root;

    public void Insertar(int key){
        root = insertarAVL(root, key);
    }
    
    private NodoAVL insertarAVL(NodoAVL nodoActual, int key){
        if(nodoActual == null){
            return (new NodoAVL(key));
        }

        if(key < nodoActual.key){
            nodoActual.left = insertarAVL(nodoActual.left, key);
        }else if(key > nodoActual.key){
            nodoActual.right = insertarAVL(nodoActual.right, key);
        }else{//Si la clave esta duplicada, retorna el nodo encontrado
            return nodoActual;
        }

        //actualizamos la altura
        nodoActual.altura = 1 + (Math.max(getAltura(nodoActual.left), getAltura(nodoActual.right)));

        //Se obtiene el factor de equilibrio
        int fe = getFactorEquilibrio(nodoActual);

        //Rotaciones
        //Rotacion a la derecha
        if(fe > 1 && key < nodoActual.left.key){
            return rightRotate(nodoActual);
        }

    }

    private int getAltura(NodoAVL nodoActual){
        if(nodoActual == null){
            return 0;
        }
        //No es necesario recorrer el arbol para determinar la altura
        //ya que en las rotaciones esta se va actualizando
        return nodoActual.altura;
    }

    private int getFactorEquilibrio(NodoAVL nodoActual){
        if(nodoActual == null){
            return 0;
        }

        return (getAltura(nodoActual.left) - getAltura(nodoActual.right));
    }
}