package ch.hslu.sw08.a1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ch.hslu.sw08.a1.SortingAlgorithms.selectionSort;

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
        int[] numbers = getShuffledNumbers(50);

        // Bubble Sort aufrufen
        int comparisons = selectionSort(numbers);
        // int comparisons = insertionSort(numbers);
        // int comparisons = bubbleSort(numbers);

        // Vergleichszähler ausgeben
        System.out.println("Anzahl Vergleiche: " + comparisons);
    }
}
