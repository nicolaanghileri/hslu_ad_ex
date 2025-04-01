# 1 Wait-Pool-Demo

## a)

### Fehler in DemoWaitPool:
Fehler der gefunden wird: "Invoking Object.notify outside a synchronized context"

Das Objekt "LOCK" wird notified, aber dies wird nicht in einem gesyncten block gemacht.

### Korrektur 

synchronized(LOCK){} als Block rund um.

### Fehler in MyTask:

Fehler der gefunden wird: Invoking Object.wait outside a synchronized context

Ich dark wait() nur aufrufen wenn ich "synchronized" auf dem selben objekt bin.

### Korrektur

Ich setze das lock Objekt auf wait, das in dem Block auch synchronized ist. 
Also: lock.wait();

## b)

### Was passiert? 

Exception in thread "Thread-0" java.lang.IllegalMonitorStateException: current thread is not owner
        at java.base/java.lang.Object.wait0(Native Method)
        at java.base/java.lang.Object.wait(Object.java:366)
        at java.base/java.lang.Object.wait(Object.java:339)
        at ch.hslu.sw06.waitpool.MyTask.run(MyTask.java:42)
        at java.base/java.lang.Thread.run(Thread.java:1583)
Exception in thread "main" java.lang.IllegalMonitorStateException: current thread is not owner
        at java.base/java.lang.Object.notify(Native Method)
        at ch.hslu.sw06.waitpool.DemoWaitPool.main(DemoWaitPool.java:40)

### Erklärung 

Dies Passiert weil ich methoden auf Objekte aufrufe, die aber auf einen Thread zugreifen wollen auf den ich nicht synchronized bin.

### Korrekturen 

Siehe oben.

Varianten: 

synchronized methode und nicht ein Synchronized Block.

## c)

Das Programm Endet nicht, da notify zu früh kam,w waiter checkt nicht rechtzeitig das LOCK wieder frei ist und hängt.

## Reflektion 

### Was ist bei `notify()` / `notifyAll()` zu beachten?
- Nur innerhalb von `synchronized` erlaubt  
- Weckt nur Threads, die auf dasselbe Objekt warten  
- Aufgeweckte Threads brauchen Monitor, um weiterzulaufen  

### Warum wird `notifyAll()` empfohlen?
- Vermeidet Deadlocks und verlorene Benachrichtigungen  
- Weckt alle wartenden Threads – sicherer bei komplexen Bedingungen  

### Was ist bei `notifyAll()` zu berücksichtigen?
- Alle Threads wachen auf → mehr CPU-Last möglich  
- Jeder Thread muss selbst prüfen, ob die Bedingung erfüllt ist (`while` statt `if`)  


# Pferderennen
## Infos
Latch = geschlossene Tür
acquire() = warten vor der Tür
release() = Tür auf → alle dürfen durch

# 3 Signalgeber – Reflektion

## a) Fairness des Semaphors
1. **Wie fair ist das vorgestellte Semaphor?**  
   - Es ist rudimentär und **nicht wirklich fair** – es gibt keine garantierte Reihenfolge (FIFO) für wartende Threads.

2. **Ursache für die Fairness (oder deren Fehlen):**  
   - Die Implementierung verwendet `wait()`/`notifyAll()` ohne eigene Warteschlangenlogik, sodass die Reihenfolge der Aufrufe dem JVM-Scheduler überlassen wird. Das kann zu willkürlichen Wake-Ups und potenziell verlorenen Signalen führen.

3. **Verbesserungsmöglichkeiten:**  
   - Eine explizite FIFO-Warteschlange einführen, in der Threads in der Reihenfolge ihres Eintreffens abgearbeitet werden.  
   - Alternativ auf eine fertige, faire Synchronisationsklasse aus `java.util.concurrent` zurückgreifen.

---

## b) Verbesserungspotenzial in der `release()`-Methode
1. **Verbesserungspotenzial:**  
   - Die aktuelle `release()`-Methode ruft stets `notifyAll()` auf, wodurch **alle** wartenden Threads geweckt werden – oft auch mehr als notwendig, was zu unnötigen Kontextwechseln führen kann.

2. **Notwendiges zur Umsetzung:**  
   - Es wäre hilfreich, die **Anzahl der wartenden Threads** zu kennen, um gezielt nur so viele Threads zu benachrichtigen, wie gerade ein Permit benötigen.  
   - Eine explizite Warteschlange (FIFO) oder Zählmechanismen könnten hier helfen.

---

## c) Nach oben begrenztes Semaphor
1. **Ungültige Argumente beim Konstruktor:**  
   - `permits < 0`  
   - `limit <= 0`  
   - `permits > limit`  
   Diese Werte führen zu einer `IllegalArgumentException`.

2. **Default-Konstruktor:**  
   - Der Default-Konstruktor sollte das Semaphor so initialisieren, dass die **Anzahl der verfügbaren Permits gleich dem Limit** ist (d.h. alle erlaubten Zutritte sind initial frei).

3. **Betroffene Methoden:**  
   - Methoden, die Permits freigeben – also `release()` und `release(int permits)` – müssen prüfen, ob durch die Freigabe das Limit überschritten wird.

4. **Reaktion beim Überschreiten des Limits:**  
   - Diese Methoden sollten entweder eine `IllegalArgumentException` werfen oder den zusätzlichen Freigabewert ignorieren, sodass die Gesamtzahl der Permits niemals über das Limit steigt.

---

## d) Erweiterung um `acquire(int)` und `release(int)`
- **Ziel:**  
  - Mehrere Permits in einem Aufruf erwerben oder freigeben.

- **Wichtige Punkte:**  
  - **Eingabevalidierung:** Negative Werte dürfen nicht erlaubt sein.  
  - **Bei `acquire(int permits)`:**  
    - Der Thread muss blockieren, falls nicht genügend Permits vorhanden sind.  
  - **Bei `release(int permits)`:**  
    - Vor der Freigabe muss geprüft werden, ob durch die zusätzlichen Permits das Limit überschritten wird (sonst Exception oder Fehlerbehandlung).

---

## e) Test des erweiterten Semaphors
- **Testfälle sollten prüfen:**  
  - **Ungültige Argumente:** Aufrufe wie `acquire(-1)`, `release(-1)` oder Freigaben, die das Limit überschreiten, müssen korrekt abgefangen werden.  
  - **Normaler Ablauf:** Mehrere Threads fordern Permits an und geben sie wieder frei – die Synchronisation muss hier stimmen.  
  - **Grenzfälle:** Es muss getestet werden, dass bei Erreichen des Limits keine weiteren Freigaben erfolgen und dass wartende Threads korrekt geweckt werden, sobald genügend Permits verfügbar sind.

---


