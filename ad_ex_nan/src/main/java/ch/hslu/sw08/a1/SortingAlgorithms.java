package ch.hslu.sw08.a1;

import ch.hslu.sw08.a1.animation.SortingAnimation;

public class SortingAlgorithms {

    public static int insertionSort(int[] numbers) {
        int comparisons = 0;

        for (int i = 1; i < numbers.length; i++) {
            int x = numbers[i];
            int j = i;
            while (j > 0) {
                comparisons++;

                if (numbers[j - 1] > x) {
                    numbers[j] = numbers[j - 1];
                    j--;
                    SortingAnimation.instance().showArray(numbers, 10, j, j + 1);

                } else {
                    break;
                }
            }
            numbers[j] = x;

            SortingAnimation.instance().showArray(numbers, 10, j);
        }
        return comparisons;
    }

    public static int selectionSort(int[] numbers) {
        int comparisons = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                comparisons++;
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }

            SortingAnimation.instance().showArray(numbers, 30, i);
        }

        return comparisons;
    }

    public static int bubbleSort(int[] numbers) {
        int comparisons = 0;
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;

                if (numbers[j] > numbers[j + 1]) {
                    // Vertauschen
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;

                    SortingAnimation.instance().showArray(numbers, 30, j, j + 1);
                }
            }
            SortingAnimation.instance().showArray(numbers, 30, n - 1 - i);
        }

        return comparisons;
    }

    // Quicksort Block
    
    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partition(numbers, start, end);

            quickSort(numbers, start, p);
            quickSort(numbers, p + 1, end);
        }
    }

    private static long comparisons = 0;
    public static long quickSort(final int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        if (start < end) {
            int p = partition(numbers, start, end);

            quickSort(numbers, start, p);
            quickSort(numbers, p + 1, end);
        }
        return comparisons;
    }

    private static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[start];
        int i = start - 1;
        int j = end + 1;

        while (true) {
            do {
                i++;
                comparisons++;
                //SortingAnimation.instance().showArray(numbers, 30, i);
            } while (numbers[i] < pivot);

            do {
                j--;
                comparisons++;
                //SortingAnimation.instance().showArray(numbers, 30, j);
            } while (numbers[j] > pivot);

            comparisons++;
            if (i >= j) {
                //SortingAnimation.instance().showArray(numbers, 30, j);
                return j;
            }

            // tausche numbers[i] und numbers[j]
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;

            //SortingAnimation.instance().showArray(numbers, 30, i);
        }
    }

}
