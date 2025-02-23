package ch.hslu.sw01.zug;

public final class ZugSimulation {

    public static int berechneGesamtPlätze(Wagen wagen){
        int sumSeats = 0;
        Wagen currentWagen = wagen;
        do {
            sumSeats += currentWagen.getSeats();
            currentWagen = currentWagen.getNextWagen();
        } while (currentWagen != null);
        return sumSeats;
    }

    public static void main(String[] args) {

        // v1.0

        Wagen wagen1 = new Wagen(1, 60);
        Wagen wagen2 = new Wagen(2, 40);
        Wagen wagen3 = new Wagen(3, 80);

        wagen1.setNextWagen(wagen2);
        wagen2.setNextWagen(wagen3);

        System.out.println("Total seats: " + berechneGesamtPlätze(wagen1));

        // v2.0

        Wagen w = new Wagen(1, 60, new Wagen(2, 40, new Wagen(3, 80)));

        System.out.println("Total seats: " + berechneGesamtPlätze(w));
    }
}
