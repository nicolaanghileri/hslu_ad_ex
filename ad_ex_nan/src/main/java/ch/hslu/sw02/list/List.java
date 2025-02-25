package ch.hslu.sw02.list;

/**
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 25.02.2025
 */
public class List {

    private Node<Integer> head;

    public List(Node<Integer> head) {
        this.head = head;
    }

    public List() {
        this.head = null;
    }

    public int size() {
        if (head != null) {
            int sum = 0;
            Node<Integer> currentNode = head;
            do {
                sum++;
                currentNode = currentNode.getNext();
            } while (currentNode != null);
            return sum;
        }
        return 0;

    }

    public void add(Node<Integer> node){
        Node<Integer> old = this.head;
        this.head = node;
        this.head.setNext(old);
    }

    public static void main(String[] args) {
        List list = new List(new Node<Integer>(2));
        System.out.println(list.size());
    }

}
