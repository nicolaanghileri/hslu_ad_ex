package ch.hslu.sw01.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {

    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    public static int fiboRec1(int n) {
        // Rekursionsbasis wenn n == 0 ider n == 1:
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Rekursionsvorschrift:
            return fiboRec1(n - 1) + fiboRec1(n - 2);
        }
    }

    private static int[] memo; // Array zur Speicherung von Zwischenresultaten

    public static int fiboRec2(int n) {
        if (memo == null) {
            memo = new int[n + 1]; // Initialisiere das Memo-Array, falls es noch nicht existiert
            for (int i = 0; i <= n; i++) {
                memo[i] = -1; // Initialisiere alle Werte mit -1 (noch nicht berechnet)
            }
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        // Falls der Wert bereits berechnet wurde, direkt zurückgeben
        if (memo[n] != -1) return memo[n];

        // Berechnung mit Memoization und Speichern im Array
        memo[n] = fiboRec2(n - 1) + fiboRec2(n - 2);
        return memo[n];
    }

    public static int fiboIter(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b; 
            a = b;      
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        // Time for Fibo 1
        long start = System.nanoTime();
        fiboRec1(40);
        long end = System.nanoTime();

        logger.info("fiboRec1(40) took {} ns", end - start);

        // Time for Fibo 2
        start = System.nanoTime();
        fiboRec2(40);
        end = System.nanoTime();

        logger.info("fiboRec2(40) took {} ns", end - start);
        
        start = System.nanoTime();
        fiboIter(40);
        end = System.nanoTime();

        logger.info("fiboIter(40) took {} ns", end - start);
    }
}
