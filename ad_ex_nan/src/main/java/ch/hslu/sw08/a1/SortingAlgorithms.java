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
}
