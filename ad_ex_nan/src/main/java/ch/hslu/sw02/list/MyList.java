package ch.hslu.sw02.list;

/**
 * Self made version of a List in Java.
 * 
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 03.03.2025
 */
public class MyList<T> {

    private Node<T> head;

    private int size = 0;

    public MyList(Node<T> head) {
        this.head = head;

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        this.size = count;
    }

    public MyList() {
        this.head = null;
    }

    public int size() {
        return this.size;
    }

    public void insert(T value) {
        if (value != null) {
            Node<T> newHead = new Node(value);
            newHead.setNext(this.head);
            this.head = newHead;
            this.size++;
        }

    }

    public boolean contains(T value) {
        if (head != null && value != null) {
            Node<T> currentNode = head;
            do {
                if (currentNode.getValue().equals(value)) {
                    return true;
                }
                currentNode = currentNode.getNext();
            } while (currentNode != null);
        }
        return false;
    }

    public T removeFirst() {
        if (head != null) {
            T returnValue = this.head.getValue();
            this.head = this.head.getNext();
            this.size--;
            return returnValue;
        }
        return null;
    }

    public boolean remove(T value) {
        if (head != null && value != null) {
            if (this.head.getValue().equals(value)) {
                removeFirst();
                return true;
            }
            Node<T> currentNode = this.head.getNext();
            Node<T> lastNode = this.head;
            do {
                if (currentNode.getValue().equals(value)) {
                    lastNode.setNext(currentNode.getNext());
                    this.size--;
                    return true;
                }
                lastNode = currentNode;
                currentNode = currentNode.getNext();
            } while (currentNode != null);
        }
        return false;
    }

}
