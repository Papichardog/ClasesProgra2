package Clase3.ArbolInsercion;

public class Main {
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Inorder:");
        arbol.mostrarInorder();

        arbol.eliminar(70);

        System.out.println("\nDespués de eliminar 70:");
        arbol.mostrarInorder();


    }

}
