/*
 * Copyright 2025 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw06.latch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);
    private static final int HORSES = 5;

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) {
        final Synch starterBox = new Latch();
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= HORSES; i++) {
            Thread t = Thread.startVirtualThread(new RaceHorse(starterBox, "Horse " + i));
            threads.add(t);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        LOG.info("Start...");
        starterBox.release();

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                LOG.error(e.getMessage());
            }
        }
        
        LOG.info("Alle Pferde sind im Ziel. Rennen beendet.");

    }
}
