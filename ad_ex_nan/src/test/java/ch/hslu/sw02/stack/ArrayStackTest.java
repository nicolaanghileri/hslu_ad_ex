package ch.hslu.sw02.stack;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    @Test
    void testCreateEmptyStack() {
        Stack<String> stack = new ArrayStack<>(10);
        assertTrue(stack.isEmpty(), "Neu erstellter Stack sollte leer sein.");
    }

    @Test
    void testCreateStackAndPushOneElement() {
        Stack<String> stack = new ArrayStack<>(10);
        stack.push("Erstes Element");
        assertFalse(stack.isEmpty(), "Nach Einfügen eines Elements darf der Stack nicht mehr leer sein.");
    }

    @Test
    void testOneCapacityStackIsFullAfterPush() {
        Stack<String> stack = new ArrayStack<>(1);
        stack.push("Element");
        assertTrue(stack.isFull(), "Stack mit Kapazität 1 sollte nach erstem Push voll sein.");
    }
}
