package ch.hslu.sw06.signal;
/**
 * 
 * // OPTIONALE LOSUNG 
 * 
 * Ein nach oben begrenztes Semaphor. Der Semaphorenzähler kann nicht unendlich wachsen.
 */
public final class Semaphore {

    private int sema; // Semaphorenzähler
    private int count; // Anzahl der wartenden Threads.
    private int limit; // Maximale Anzahl an Passiersignalen.

    /**
     * Erzeugt ein Semaphore mit 0 Passiersignalen (unbeschränkt, da limit = Integer.MAX_VALUE).
     */
    public Semaphore() {
        this(0);
    }

    /**
     * Erzeugt ein Semaphore mit einem Initialwert für den Semaphorenzähler.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @throws IllegalArgumentException wenn der Initialwert negativ ist.
     */
    public Semaphore(final int permits) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        sema = permits;
        count = 0;
        // Bei der ein-argumentigen Variante gilt kein explizites Limit
        limit = Integer.MAX_VALUE;
    }

    /**
     * Erzeugt ein nach oben begrenztes Semaphore.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be > 0, but was " + limit);
        }
        if (permits < 0 || permits > limit) {
            throw new IllegalArgumentException("Permits (" + permits + ") must be between 0 and limit (" + limit + ")");
        }
        sema = permits;
        count = 0;
        this.limit = limit;
    }

    /**
     * Entspricht dem P()-Betreten eines synchronisierten Bereichs.
     * Falls der Zähler 0 ist, wird der Aufrufer blockiert.
     *
     * @throws InterruptedException falls das Warten unterbrochen wird.
     */
    public synchronized void acquire() throws InterruptedException {
        while (sema == 0) {
            count++;
            this.wait();
            count--;
        }
        sema--;
    }

    /**
     * Entspricht dem P()-Betreten eines synchronisierten Bereichs für mehrere Permits.
     * Falls nicht genügend Permits vorhanden sind, wird blockiert.
     *
     * @param permits Anzahl Passiersignale zum Eintritt.
     * @throws InterruptedException falls das Warten unterbrochen wird.
     * @throws IllegalArgumentException wenn permits <= 0.
     * @throws ArithmeticException wenn die angeforderten Permits das Limit überschreiten.
     */
    public synchronized void acquire(final int permits) throws InterruptedException {
        if (permits <= 0) {
            throw new IllegalArgumentException("permits must be positive: " + permits);
        }
        if (permits > limit) {
            throw new ArithmeticException("Requested permits (" + permits + ") exceed semaphore limit (" + limit + ")");
        }
        while (sema < permits) {
            count++;
            this.wait();
            count--;
        }
        sema -= permits;
    }

    /**
     * Entspricht dem V()-Verlassen eines synchronisierten Bereichs.
     * Es wird überprüft, ob durch die Freigabe das Limit überschritten würde.
     */
    public synchronized void release() {
        if (sema + 1 > limit) {
            throw new ArithmeticException("Semaphore limit exceeded: " + limit);
        }
        sema++;
        this.notifyAll();
    }

    /**
     * Entspricht dem V()-Verlassen eines synchronisierten Bereichs für mehrere Permits.
     *
     * @param permits Anzahl Passiersignale zur Freigabe.
     * @throws IllegalArgumentException wenn permits <= 0.
     * @throws ArithmeticException wenn das Limit durch die Freigabe überschritten wird.
     */
    public synchronized void release(final int permits) {
        if (permits <= 0) {
            throw new IllegalArgumentException("permits must be positive: " + permits);
        }
        if (sema + permits > limit) {
            throw new ArithmeticException("Release would exceed semaphore limit: " + limit);
        }
        sema += permits;
        this.notifyAll();
    }

    /**
     * Gibt die Anzahl der wartenden Threads zurück.
     *
     * @return Anzahl wartender Threads.
     */
    public synchronized int pending() {
        return count;
    }
}
