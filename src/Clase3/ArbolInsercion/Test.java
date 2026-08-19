package Clase3.ArbolInsercion;

public class Test {
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("ÁRBOL ORIGINAL");
        System.out.print("Inorder: ");
        arbol.mostrarInorder();

        System.out.println();

        System.out.print("Preorder: ");
        arbol.mostrarPreorden();

        System.out.println();

        System.out.print("Postorder: ");
        arbol.mostrarPostorder();

        System.out.println();

        arbol.eliminar(70);

        System.out.println("\nÁRBOL DESPUÉS DE ELIMINAR 70");

        System.out.print("Inorder: ");
        arbol.mostrarInorder();

        System.out.println();

        System.out.print("Preorder: ");
        arbol.mostrarPreorden();

        System.out.println();

        System.out.print("Postorder: ");
        arbol.mostrarPostorder();


    }

}
