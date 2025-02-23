package ch.hslu.sw01.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task {

    private static final Logger logger = LoggerFactory.getLogger(Task.class);

    private static int countTask1 = 0;
    private static int countTask2 = 0;
    private static int countTask3 = 0;

    public static void task1() {
        countTask1++;
        try {
            Thread.sleep(5); // Simulierte konstante Laufzeit
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void task2() {
        countTask2++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void task3() {
        countTask3++;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            for (int j = 0; j < n; j++) {
                task3();
                task3();
            }
        }
    }

    private static void resetCounters() {
        countTask1 = 0;
        countTask2 = 0;
        countTask3 = 0;
    }

    public static void main(String[] args) {
        int[] testValues = {1, 2, 5, 10, 20, 50, 100}; // Beispielwerte für n

        for (int n : testValues) {
            resetCounters();
            long startTime = System.currentTimeMillis(); // Startzeit messen
            task(n);
            long endTime = System.currentTimeMillis(); // Endzeit messen
            long duration = endTime - startTime; // Berechnete Laufzeit

            logger.info("Für n = {}: Laufzeit = {}ms, task1-Aufrufe = {}, task2-Aufrufe = {}, task3-Aufrufe = {}",
                    n, duration, countTask1, countTask2, countTask3);
        }
    }

}
