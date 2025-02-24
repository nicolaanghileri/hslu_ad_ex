package ch.hslu.sw01.runtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    void testFiboBaseCases() {
        // Teste die Basisfälle
        assertEquals(0, Fibonacci.fiboRec1(0), "F(0) sollte 0 sein");
        assertEquals(1, Fibonacci.fiboRec1(1), "F(1) sollte 1 sein");
    }

    @Test
    void testFiboSmallNumber() {
        // Teste eine kleine Zahl, die aus der Rekursionsvorschrift berechnet wird
        assertEquals(5, Fibonacci.fiboRec1(5), "F(5) sollte 5 sein");
    }

    @Test
    void testFiboLargerNumber() {
        // Teste eine größere Zahl
        assertEquals(55, Fibonacci.fiboRec1(10), "F(10) sollte 55 sein");
    }

    @Test
    void testFiboBaseCases_2() {
        // Teste die Basisfälle
        assertEquals(0, Fibonacci.fiboRec2(0), "F(0) sollte 0 sein");
        assertEquals(1, Fibonacci.fiboRec2(1), "F(1) sollte 1 sein");
    }

    @Test
    void testFiboSmallNumber_2() {
        // Teste eine kleine Zahl
        assertEquals(5, Fibonacci.fiboRec2(5), "F(5) sollte 5 sein");
    }

}
