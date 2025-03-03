package ch.hslu.sw02.list;


/**
 * Self made version of a Node in Java.
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 03.03.2025 
 */
public class Node<T> {
    public T value;

    public Node<T> next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
