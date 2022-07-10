import org.w3c.dom.ls.LSParserFilter;
import org.w3c.dom.traversal.NodeIterator;

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

        if(fe < -1 && key > nodoActual.right.key){
            return leftRotate(nodoActual);
        }

        //Rotacion doble izquierda Derecha
        if(fe > 1 && key>nodoActual.left.key){
            nodoActual.left = leftRotate(nodoActual.left);
            return rightRotate(nodoActual);
        }

        //Rotacion doble derecha izquierda
        if(fe < -1 && key < nodoActual.right.key){
            nodoActual.right = rightRotate(nodoActual.right);
            return leftRotate(nodoActual);
        }
        return nodoActual;
    }

    private boolean BuscaAVL(NodoAVL nodoActual, int elemento){
        if(nodoActual == null){
            return false;
        }else if (elemento == nodoActual.key){
            return true;
        }else if(elemento < nodoActual.key){
            return BuscaAVL(nodoActual.left, elemento);
        }else{
            return BuscaAVL(nodoActual.right, elemento);
        }
    }

    public void eliminar(int key){
        root = eliminarAVL(root, key);
    }

    private NodoAVL eliminarAVL(NodoAVL nodoActual, int key){
        if(nodoActual == null){
            return nodoActual;
        }
        if(key < nodoActual.key){
            nodoActual.left = eliminarAVL(nodoActual.left, key);
        }else if(key > nodoActual.key){
            nodoActual.right = eliminarAVL(nodoActual.right, key);
        }else{
            //El nodo es igual a la clave, se elimina
            //Nodo con un unico hijo o es hoja
            if((nodoActual.left == null) || (nodoActual.right == null)){
                NodoAVL temp = null;
                if(temp == nodoActual.left){
                    temp = nodoActual.right;
                }else{
                    temp = nodoActual.left;
                }

                //Caso que no tiene hijos
                if(temp == null){
                    nodoActual = null;//Se elimina dejandolo en null
                }else{
                    //Caso con un hijo
                    nodoActual = temp;//Elimina el valor actual reemplazandolo por su hijo
                }
            }else{
                //Nodo con dos hijos, se busca al predecesor
                NodoAVL temp = getNodoConValorMaximo(nodoActual.left);

            //Se copia el dato del predecesor
            nodoActual.key = temp.key;

            //Se elimina el predecesor
            nodoActual.left = eliminarAVL(nodoActual.left, temp.key);
        }
    }
    //Si solo tiene un nodo
    if(nodoActual == null){
        return nodoActual;
    }

    //Actualiza la altura
    nodoActual.altura = Math.max(getAltura(nodoActual.left), getAltura(nodoActual.right)) + 1;

    //Calcula factor de equilibrio (FE)
    int fe = getFactorEquilibrio(nodoActual);

    //Se realizan las rotaciones pertinentes dado el FE
    //Rotacion simple derecha
    if(fe > 1 && getFactorEquilibrio(nodoActual.left) >= 0){
        return rightRotate(nodoActual);
    }

    //Caso Rotacion simple izquierda
    if(fe < -1 && getFactorEquilibrio(nodoActual.right) <= 0){
        return leftRotate(nodoActual);
    }

    //Caso rotacion doble izquierda derecha
    if(fe > 1 && getFactorEquilibrio(nodoActual.left) < 0){
        nodoActual.left = leftRotate(nodoActual.left);
        return rightRotate;
    }

    //Caso rotacion doble derecha izquierda
    if(fe < -1 && getFactorEquilibrio(nodoActual.right) > 0){
        nodoActual.right = rightRotate(nodoActual.right);
        return leftRotate(nodoActual);
    }
    return nodoActual;
}

    //ROTACIONES
    //rotacion a la derecha
    private NodoAVL rightRotate(NodoAVL nodoActual){
        NodoAVL nuevaRaiz = nodoActual.left;
        NodoAVL temp = nuevaRaiz.right;

        //Se realiza la rotacion
        nuevaRaiz.right = nodoActual;
        nodoActual.left = temp;
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