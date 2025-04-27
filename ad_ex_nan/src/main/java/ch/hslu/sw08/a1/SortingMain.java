package ch.hslu.sw08.a1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ch.hslu.sw08.a1.SortingAlgorithms.quickSort;

public class SortingMain {

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in zufälliger Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     *
     */
    static int[] getShuffledNumbers(int size) {
        List<Integer> numbers = IntStream.range(1, size + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in aufsteigender Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     */
    static int[] getAscendingNumbers(int size) {
        return IntStream.range(1, size + 1).toArray();
    }

    /**
     * Liefert ein Array mit den Zahlen 1 bis size in absteigender Reihenfolge.
     *
     * @param size die Anzahl der Zahlen
     */
    static int[] getDescendingNumbers(int size) {
        return IntStream.range(1, size + 1).map(i -> size - i + 1).toArray();
    }

    public static void main(String[] args) {

        List<Double> durations = new ArrayList<>();
        List<Long> comparisons = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int[] numbers = getShuffledNumbers(1000000);

            long startTime = System.nanoTime();
            long comparison = quickSort(numbers);
            long endTime = System.nanoTime();

            // 5) Berechne Laufzeit in Millisekunden
            long durationNs = endTime - startTime;
            double durationMs = durationNs / 1_000_000.0;

            durations.add(durationMs);
            comparisons.add(comparison);
        }

        for (Long value : comparisons) {
            System.out.println(value);
        }

        for (Double value : durations) {
            System.out.println(value);
        }

    }
}
