package ch.hslu.sw03.binarytree;

/**
 * Interface that defines a BinaryTree.
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 09.03.2025 
 */
public interface BinaryTreeable<T> {
    /**
     * Inserts a new Node containig value.
     * @param value the value that the node contains.
     */
    public void insert(T value);
    /**
     * Returns the size of the Tree.
     * @return the size.
     */
    public int size();
    /**
     * Removes the containig value.
     * @param value the values that is beeing searched.
     * @return true if succeded.
     */
    public boolean remove(T value);
    /**
     * Returns if value in contained in the tree.
     * @param value the value that is beeing searched.
     * @return true value is contained.
     */
    public boolean contains(T value);
    /**
     * Returns is Tree is Empty.
     * @return true if empty.
     */
    public boolean isEmpty();
}
