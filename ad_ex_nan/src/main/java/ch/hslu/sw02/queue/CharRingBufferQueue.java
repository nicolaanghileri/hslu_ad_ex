package ch.hslu.sw02.queue;

/**
 * RingBufferQueue für Chars.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 08.03.2025
 */
public class CharRingBufferQueue {
    private final char[] data;  // Array für die Queue
    private final int capacity; // Kapazität
    
    private int head;
    private int tail; 
    private int size;

    public CharRingBufferQueue(int capacity) {
        this.capacity = capacity;
        this.data = new char[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }


    public boolean isEmpty() {
        return (size == 0);
    }


    public boolean isFull() {
        return (size == capacity);
    }


    public void enqueue(char c) {
        if (isFull()) {
            throw new RuntimeException("Queue ist voll – Enqueue nicht möglich!");
        }
        data[tail] = c;
        tail = (tail + 1) % capacity;  // Ring-Umlauf
        size++;
    }

    
    public char dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue ist leer – Dequeue nicht möglich!");
        }
        char result = data[head];
        head = (head + 1) % capacity;  // Ring-Umlauf
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue mit ").append(size).append(" Elementen: [");
        for (int i = 0; i < size; i++) {
            sb.append(data[(head + i) % capacity]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CharRingBufferQueue queue = new CharRingBufferQueue(8);

        // Ein paar Elemente einfügen
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        System.out.println(queue); // z. B. "Queue mit 3 Elementen: [A, B, C]"

        // Ein Element entnehmen
        char removed = queue.dequeue();
        System.out.println("Entnommen: " + removed); // "A"
        System.out.println(queue); // "Queue mit 2 Elementen: [B, C]"

        // Bis zum Ende auffüllen
        queue.enqueue('D');
        queue.enqueue('E');
        queue.enqueue('F');
        queue.enqueue('G');
        queue.enqueue('H');
        System.out.println(queue); // jetzt 7 Elemente
        
        queue.enqueue('X');
        System.out.println(queue);
        System.out.println("Voll? " + queue.isFull());
    }
}