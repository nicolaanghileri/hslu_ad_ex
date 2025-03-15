package ch.hslu.sw03.binarytree;

public class Main {

    public static void main(String[] args) {
        // Erstelle ein BinaryTree-Objekt
        BinaryTree<Integer> myTree = new BinaryTree<>();

        // Inorder-Traversierung (sollte sortierte Ausgabe sein, falls kein Zyklus)
        System.out.println("Inorder Traversal (initialer Baum):");
        myTree.inOrderTraverse();
        // Erwartete Reihenfolge der Werte: 4 5 6 7 8 10 12 13 15 17

     
        System.out.println("\nSuche im Baum:");
        System.out.println("Enthält der Baum '7'?  " + myTree.search(7, myTree.getRoot()));
        System.out.println("Enthält der Baum '99'? " + myTree.search(99, myTree.getRoot()));

        // Neue Werte einfügen (iterativ)
        System.out.println("\nFüge neue Werte (iterativ) ein: 20, 9, 2");
        myTree.insert(20);
        myTree.insert(9);
        myTree.insert(2);

        System.out.println("Inorder Traversal (nach Einfügen):");
        myTree.inOrderTraverse();
        // Neue Werte (2, 9, 20) sollten nun in der Ausgabe auftauchen

        // Aktuelle Größe
        System.out.println("\nAktuelle Größe: " + myTree.size());

        // Rekursives Einfügen (in der aktuellen Form ändert es NICHTS, da 'insertRecursive' 
        //    den Knoten lokal anlegt und nicht zurückgibt - wir zeigen es nur als Beispiel)
        System.out.println("\nFüge neue Werte (rekursiv) ein: 25, 1, 11");
        myTree.insertRecursive(myTree.getRoot(), 25);
        myTree.insertRecursive(myTree.getRoot(), 1);
        myTree.insertRecursive(myTree.getRoot(), 11);

        System.out.println("Inorder Traversal (nach rekursivem Einfügen):");
        myTree.inOrderTraverse();
        // KEINE Änderung, weil insertRecursive(...) so nicht funktioniert

        // Finale Größe
        System.out.println("\nFinale Größe: " + myTree.size()); 
    }
}
