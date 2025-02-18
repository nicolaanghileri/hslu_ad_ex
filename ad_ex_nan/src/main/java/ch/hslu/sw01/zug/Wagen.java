package ch.hslu.sw01.zug;

import java.util.Objects;

/**
 * Abstract model of a Wagon - possibly followed by another Wagon.
 * 
 * @author nicola.anghileri@stud.hslu.ch
 * @version sw01 - 18.02.2025
 */
public class Wagen {
    private int id;
    private int seats;
    private Wagen nextWagen = null;

    public Wagen(int id, int seats, Wagen nextWagen){
        this.id = id;
        this.seats = seats;
        this.nextWagen = nextWagen;
    }

    public Wagen(int id, int seats){
        this.id = id;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if(seats <= 0){
            throw new IllegalArgumentException("seats has to be greater than zero");
        }
        this.seats = seats;
    }

    public Wagen getNextWagen() {
        return nextWagen;
    }

    public void setNextWagen(Wagen nextWagen) {
        this.nextWagen = nextWagen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Wagen wagen) && (wagen.getId() == this.id);
    }

    public boolean hasNextWagon(){
        return (this.nextWagen != null);
    }

}
