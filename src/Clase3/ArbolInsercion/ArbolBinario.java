package Clase3.ArbolInsercion;

public class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarNodo(raiz, valor);
    }
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

    // ==========================
    // RECORRIDO PREORDEN
    // ==========================
    public void preorder(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorder(nodo.izquierdo);
            preorder(nodo.derecho);
        }
    }

    // ==========================
    // RECORRIDO INORDER
    // ==========================
    public void inorder(NodoArbol nodo) {
        if (nodo != null) {
            inorder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorder(nodo.derecho);
        }
    }

    // ==========================
    // RECORRIDO POSTORDER
    // ==========================
    public void postorder(NodoArbol nodo) {
        if (nodo != null) {
            postorder(nodo.izquierdo);
            postorder(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarNodo(raiz, valor);
    }

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
    private NodoArbol encontrarMinimo(NodoArbol nodo) {

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo;
    }
}
