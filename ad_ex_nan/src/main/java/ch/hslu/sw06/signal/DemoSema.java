package ch.hslu.sw06.signal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * // OPTIONALE LOSUNG 
 * Demonstration verschiedener Initialisierungen eines nach oben begrenzten Semaphors.
 */
public final class DemoSema {

    private static final Logger LOG = LoggerFactory.getLogger(DemoSema.class);

    /**
     * Privater Konstruktor.
     */
    private DemoSema() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn das Warten unterbrochen wird.
     */
    public static void main(final String[] args) throws InterruptedException {
        try {
            // Ungültig, weil 4 > Limit 3
            new Semaphore(4, 3);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            // Erhöht sema von 3 auf 4, was das Limit überschreiten würde
            sema.release();
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(0, 3);
            // Versuch, 4 Permits freizugeben – überschreitet das Limit
            sema.release(4);
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            // Versuch, 4 Permits zu erwerben – das ist nicht erlaubt, da 4 > Limit
            sema.acquire(4);
        } catch (ArithmeticException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(3, 3);
            // Ungültiger Aufruf, negative Permits
            sema.acquire(-1);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
        try {
            Semaphore sema = new Semaphore(1, 3);
            // Ungültiger Aufruf, negative Permits
            sema.release(-1);
        } catch (IllegalArgumentException e) {
            LOG.debug(e.getMessage());
        }
    }
}
