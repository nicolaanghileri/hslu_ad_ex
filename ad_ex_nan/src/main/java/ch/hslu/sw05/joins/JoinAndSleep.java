package ch.hslu.sw05.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JoinAndSleep - Demo class for Threads waiting for oder Threads.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 17.03.2025
 */
public class JoinAndSleep {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleep.class);

    /**
     * Privater Konstruktor, da statische Demo-Klasse.
     */
    private JoinAndSleep() {
        // nothing here
    }

    /**
     * Main-Demo.
     *
     * @param args not used
     * @throws InterruptedException falls das Warten (join) unterbrochen wird
     */
    public static void main(String[] args) throws InterruptedException {

        // 1) Erzeuge die Tasks
        JoinAndSleepTask taskA = new JoinAndSleepTask("A", 2000);
        JoinAndSleepTask taskB = new JoinAndSleepTask("B", 3000);
        JoinAndSleepTask taskC = new JoinAndSleepTask("C", 4000);

        // 2) Erzeuge die Threads, die diese Tasks ausführen
        Thread threadA = new Thread(taskA, "ThreadA");
        Thread threadB = new Thread(taskB, "ThreadB");
        Thread threadC = new Thread(taskC, "ThreadC");

        // 3) Konfiguriere Join-Beziehungen:
        //    ThreadB wartet auf ThreadA, ThreadC wartet auf ThreadB
        taskB.setJoinFor(threadA);
        taskC.setJoinFor(threadB);

        // 4) Starte alle Threads
        LOG.info("Main: Starte ThreadA, ThreadB, ThreadC ...");
        threadA.start();
        threadB.start();
        threadC.start();

        // 5) Unterbrechungs-Demo: Main-Thread wartet kurz und unterbricht dann ThreadB
        Thread.sleep(1000);
        LOG.info("Main: Unterbreche ThreadB!");
        threadB.interrupt();

        // 6) Warte auf das Ende aller Threads
        threadA.join();
        threadB.join();
        threadC.join();

        LOG.info("Main: Alle Threads sind fertig. Ende des Programms.");
    }
}
