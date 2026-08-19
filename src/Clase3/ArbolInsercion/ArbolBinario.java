package Clase3.ArbolInsercion;

public class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Inserta un nuevo valor en el árbol binario de búsqueda.
     * Si el valor es menor se inserta a la izquierda.
     * Si es mayor se inserta a la derecha.
     */
    public void insertar(int valor) {
        raiz = insertarNodo(raiz, valor);
    }

    /**
     * Inserta un nodo de forma recursiva.
     *
     * Funcionamiento:
     * - Si el nodo actual es null, crea un nuevo nodo.
     * - Si el valor es menor, continúa por el subárbol izquierdo.
     * - Si el valor es mayor, continúa por el subárbol derecho.
     * - Finalmente devuelve el nodo actual para mantener la estructura
     *   del árbol correctamente enlazada.
     */
     private NodoArbol insertarNodo(NodoArbol actual, int valor) {

        if (actual == null) {
            return new NodoArbol(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarNodo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarNodo(actual.derecho, valor);
        }

        return actual;
    }
    public void mostrarPreorden() {
        preorder(raiz);
    }

    public void mostrarInorder() {
        inorder(raiz);
    }

    public void mostrarPostorder() {
        postorder(raiz);
    }

    /**
     * Recorre el árbol utilizando el recorrido PreOrder.
     *
     * Orden del recorrido:
     * 1. Visita la raíz.
     * 2. Recorre el subárbol izquierdo.
     * 3. Recorre el subárbol derecho.
     *
     * Este recorrido es útil para copiar un árbol o mostrar su estructura
     * jerárquica desde la raíz hacia los niveles inferiores.
     */
    private void preorder(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorder(nodo.izquierdo);
            preorder(nodo.derecho);
        }
    }

    /**
     * Recorre el árbol utilizando el recorrido InOrder.
     *
     * Orden del recorrido:
     * 1. Recorre el subárbol izquierdo.
     * 2. Visita la raíz.
     * 3. Recorre el subárbol derecho.
     *
     * En un Árbol Binario de Búsqueda (BST), este recorrido imprime
     * los elementos en orden ascendente, por lo que es uno de los
     * recorridos más utilizados.
     */
    private void inorder(NodoArbol nodo) {
        if (nodo != null) {
            inorder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorder(nodo.derecho);
        }
    }

    /**
     * Recorre el árbol utilizando el recorrido PostOrder.
     *
     * Orden del recorrido:
     * 1. Recorre el subárbol izquierdo.
     * 2. Recorre el subárbol derecho.
     * 3. Visita la raíz.
     *
     * Este recorrido es útil cuando primero se deben procesar los hijos
     * antes del padre, por ejemplo al liberar memoria o eliminar un árbol
     * completo.
     */
    private void postorder(NodoArbol nodo) {
        if (nodo != null) {
            postorder(nodo.izquierdo);
            postorder(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    /**
     * Elimina un valor del árbol binario de búsqueda.
     *
     * Este método inicia la eliminación llamando al método recursivo
     * eliminarNodo(). Si el valor existe en el árbol, se elimina
     * manteniendo la estructura y las propiedades del BST.
     */
    public void eliminar(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }


    /**
     * Elimina un nodo del árbol utilizando recursividad.
     *
     * Se consideran los tres casos clásicos:
     *
     * Caso 1:
     * El nodo no tiene hijos (es una hoja), por lo que simplemente
     * se elimina.
     *
     * Caso 2:
     * El nodo tiene un solo hijo. El hijo ocupa el lugar del nodo
     * eliminado.
     *
     * Caso 3:
     * El nodo tiene dos hijos. Se busca el sucesor InOrder
     * (el menor del subárbol derecho), se copia su valor al nodo
     * actual y luego se elimina el sucesor de su posición original.
     */
    private NodoArbol eliminarNodo(NodoArbol nodo, int valor) {

        if (nodo == null)
            return null;

        if (valor < nodo.valor) {

            nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);

        } else if (valor > nodo.valor) {

            nodo.derecho = eliminarNodo(nodo.derecho, valor);

        } else {

            // Caso 1 y Caso 2

            if (nodo.izquierdo == null)
                return nodo.derecho;

            if (nodo.derecho == null)
                return nodo.izquierdo;

            // Caso 3

            NodoArbol sucesor = encontrarMinimo(nodo.derecho);

            nodo.valor = sucesor.valor;

            nodo.derecho = eliminarNodo(nodo.derecho, sucesor.valor);
        }

        return nodo;
    }

    /**
     * Busca el nodo con el valor mínimo dentro de un subárbol.
     *
     * Para encontrar el menor valor, el algoritmo avanza siempre
     * hacia el hijo izquierdo hasta llegar al último nodo.
     *
     * Este método es utilizado durante la eliminación de un nodo
     * con dos hijos para localizar el sucesor InOrder.
     */
    private NodoArbol encontrarMinimo(NodoArbol nodo) {

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo;
    }
    /*
     * Conclusión:
     *
     * La implementación del Árbol Binario de Búsqueda permitió aplicar
     * conceptos de estructuras dinámicas, recursividad y programación
     * orientada a objetos. Las operaciones de inserción, recorrido y
     * eliminación mantienen las propiedades del BST, permitiendo
     * almacenar y recuperar información de manera organizada. Los
     * recorridos muestran diferentes formas de visitar los nodos,
     * mientras que la eliminación requiere considerar tres casos para
     * conservar correctamente la estructura del árbol.
     */
}
