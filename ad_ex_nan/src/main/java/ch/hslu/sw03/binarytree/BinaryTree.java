package ch.hslu.sw03.binarytree;

/**
 * Class that describes all basic functions for a BinaryTree.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 09.03.2025
 */
public class BinaryTree<T extends Comparable<? super T>> implements BinaryTreeable<T> {

    private Node<T> root;

    private int size = 0;

    @SuppressWarnings("unchecked")
    public BinaryTree() {
        Node node10 = new Node(10);
        Node node5 = new Node(5);
        Node node15 = new Node(15);
        Node node4 = new Node(4);
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node17 = new Node(17);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node12 = new Node(12);

        this.root = node10;

        node10.setLeftChild(node5);
        node10.setRightChild(node15);
        
        node5.setLeftChild(node4);
        node5.setRightChild(node7);
        
        node7.setLeftChild(node6);
        node7.setRightChild(node8);
        
        node15.setLeftChild(node13);
        node15.setRightChild(node17);
        
        node13.setLeftChild(node12);
    }

    public boolean search(T value, Node<T> node) {
        if (node != null) {
            int comparison = value.compareTo(node.getValue());
            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                return search(value, node.getLeftChild());
            } else if (comparison > 0) {
                return search(value, node.getRightChild());
            }
        }
        return false;
    }

    @Override
    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
            size = 1;
            return;
        }

        Node<T> current = root;

        while (true) {
            int cmp = value.compareTo(current.getValue());
            if (cmp < 0) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(newNode);
                    size++;
                    return;
                } else {
                    current = current.getLeftChild();
                }
            } else {
                if (current.getRightChild() == null) {
                    current.setRightChild(newNode);
                    size++;
                    return;
                } else {
                    current = current.getRightChild();
                }
            }
        }
    }

    public void insertRecursive(Node<T> node, T value) {
        if (node == null) {
            node = new Node(value);
            size++;
        }
        int comparison = value.compareTo(node.getValue());
        if (comparison > 0) {
            insertRecursive(node.getRightChild(), value);
        } else if (comparison < 0) {
            insertRecursive(node.getLeftChild(), value);
        }
    }

    public void inOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.getLeftChild());         // Linker Teilbaum
        System.out.print(node.getValue() + " ");      // Aktuellen Knoten ausgeben
        inOrderTraverse(node.getRightChild());        // Rechter Teilbaum
    }
    
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean remove(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean contains(T value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

}
