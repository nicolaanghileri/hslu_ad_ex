package ch.hslu.sw05.joins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Task for Joining Threads.
 *
 * @author Nicola Anghileri - nicola.anghileri@stud.hslu.ch
 * @version 17.03.2025
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);

    private final String taskName;
    private Thread joinFor;      // Falls dieser Thread != null ist, wird darauf gewartet.
    private final int sleepTime; // Zeit in ms, die geschlafen wird.

    /**
     * Erzeugt einen Task mit Namen und Schlafzeit.
     *
     * @param taskName Name des Tasks
     * @param sleepTime Zeit in ms, die geschlafen wird
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime) {
        this.taskName = taskName;
        this.sleepTime = sleepTime;
    }

    /**
     * Setzt den Thread, auf den gewartet werden soll.
     *
     * @param joinFor Thread, auf den gewartet wird
     */
    public void setJoinFor(Thread joinFor) {
        this.joinFor = joinFor;
    }

    @Override
    public void run() {
        LOG.info("Task '{}' gestartet.", taskName);

        // 1) Join-Teil (optional, nur wenn joinFor != null)
        if (joinFor != null) {
            try {
                LOG.info("Task '{}' wartet auf Thread '{}'.", taskName, joinFor.getName());
                joinFor.join();
                LOG.info("Task '{}' hat das Warten auf '{}' beendet.", taskName, joinFor.getName());
            } catch (InterruptedException ex) {
                LOG.warn("Task '{}' wurde unterbrochen, während er auf '{}' wartete!", taskName, joinFor.getName());
                return; // Abbruch des Tasks
            }
        }

        // 2) Sleep-Teil
        try {
            LOG.info("Task '{}' schläft jetzt für {} ms.", taskName, sleepTime);
            Thread.sleep(sleepTime);
            LOG.info("Task '{}' ist aufgewacht.", taskName);
        } catch (InterruptedException ex) {
            LOG.warn("Task '{}' wurde während des Schlafens unterbrochen!", taskName);
            return; // Abbruch des Tasks
        }

        LOG.info("Task '{}' beendet sich regulär.", taskName);
    }

}
