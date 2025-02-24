package ch.hslu.sw01.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Symmetric {
    private static final Logger logger = LoggerFactory.getLogger(Symmetric.class);

    public static boolean isSymmetric(int number) {
        char[] digits = Integer.toString(number).toCharArray();
        int left = 0;
        int right = digits.length - 1;

        while (left < right) {
            if (digits[left] != digits[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        
        int number = 8227228;
        boolean result = isSymmetric(number);
        
        long end = System.nanoTime();

        logger.info("Symmetrisch: " + result);
        logger.info("Laufzeit: {} ns", end - start);
    }
}