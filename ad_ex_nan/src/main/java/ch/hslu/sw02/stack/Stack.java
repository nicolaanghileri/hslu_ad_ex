package ch.hslu.sw02.stack;

/**
 * Interface that defines how a Stack has to be.
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 04.03.2025 
 */
public interface Stack<T> {
    /**
     * Method that adds a new element, on top of the Stack.
     * @param item
     */
    public void push(T item);

    /**
     * Method that removes the first accessable element, and returns it.
     * @return
     */
    public T pop();

    /**
     * Method that returns true if Stack is empty.
     * @return true if empty - false if not.
     */
    public boolean isEmpty();

    /**
     * Method that returns true if Stack is full.
     * @return true if full - false if not.
     */
    public boolean isFull();

}
