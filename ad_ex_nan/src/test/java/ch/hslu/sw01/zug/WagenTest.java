package ch.hslu.sw01.zug;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class WagenTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Wagen.class)
            .withPrefabValues(Wagen.class, new Wagen(1, 40), new Wagen(2, 100))
            .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
            .verify();
    }

    @Test
    public void testGetId(){
        Wagen w = new Wagen(1, 20);
        assertThat(w.getId()).isEqualTo(1);
    }

    @Test
    public void testGetSeats(){
        Wagen w = new Wagen(1,20);
        assertThat(w.getSeats()).isEqualTo(20);
    }

    @Test
    public void testCtorWithNextWagon(){
        Wagen w = new Wagen(20,200, new Wagen(21,20));
        assertThat(w.getId()).isEqualTo(20);
        assertThat(w.getSeats()).isEqualTo(200);
        assertThat(w.getNextWagen().getSeats()).isEqualTo(20);
    }

    @Test
    public void testCtorWithoutNextWagon(){
        Wagen w = new Wagen(20, 200);
        assertThat(w.getId()).isEqualTo(20);
        assertThat(w.getSeats()).isEqualTo(200);
        assertThat(w.getNextWagen()).isEqualTo(null);
    }

    @Test
    public void testSetId(){
        Wagen w = new Wagen(1, 20);
        w.setId(30);
        assertThat(w.getId()).isEqualTo(30);
    }

    @Test
    public void testSetSeats(){
        Wagen w = new Wagen(1, 20);
        w.setSeats(21);
        assertThat(w.getSeats()).isEqualTo(21);
    }

    @Test
    public void testSetSeatsBelowZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            Wagen w = new Wagen(1, 20);
            w.setSeats(-2);
        });
    }

    @Test
    public void testHasNextWagonTrue(){
        Wagen w = new Wagen(20,200, new Wagen(21,20));
        assertThat(w.hasNextWagon()).isTrue();
    }

    @Test
    public void testHasNextWagonFalse(){
        Wagen w = new Wagen(20,200);
        assertThat(w.hasNextWagon()).isFalse();
    }

    @Test
    public void testSetNextWagon(){
        Wagen w = new Wagen(20,200);
        w.setNextWagen(new Wagen(21, 22));
        assertThat(w.hasNextWagon()).isTrue();
    }

}
