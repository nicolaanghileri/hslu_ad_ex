package ch.hslu.sw02.stack;

import java.util.EmptyStackException;

/**
 * Self made version of a Stack.
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 04.03.2025
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] elements;

    private int topIndex;

    public ArrayStack(int capacity) {
        // In Java muss man den Umweg über Object[] gehen und casten:
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[capacity];
        this.elements = tempArray;
        this.topIndex = 0;
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        this.elements[topIndex++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = this.elements[--topIndex];
        this.elements[topIndex] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == elements.length;
    }

}
