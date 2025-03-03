package ch.hslu.sw02.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void testEmptyListSize() {
        MyList<String> list = new MyList<>();
        assertEquals(0, list.size(), 
            "Die Größe der Liste sollte 0 sein, wenn keine Elemente vorhanden sind.");
    }

    @Test
    void testInsertAndSize() {
        MyList<String> list = new MyList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");
        assertEquals(3, list.size(), 
            "Die Größe der Liste sollte nach drei Inserts 3 sein.");
    }

    @Test
    void testContains() {
        MyList<String> list = new MyList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");

        assertTrue(list.contains("A"), 
            "Liste sollte das Element 'A' enthalten.");
        assertTrue(list.contains("B"), 
            "Liste sollte das Element 'B' enthalten.");
        assertTrue(list.contains("C"), 
            "Liste sollte das Element 'C' enthalten.");
        assertFalse(list.contains("D"), 
            "Liste sollte das Element 'D' nicht enthalten.");
    }

    @Test
    void testRemoveFirst() {
        MyList<String> list = new MyList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");

        assertEquals("C", list.removeFirst(), 
            "removeFirst() sollte 'C' zurückgeben.");
        assertEquals(2, list.size(), 
            "Nach removeFirst() sollte die Größe der Liste 2 sein.");

        assertEquals("B", list.removeFirst(), 
            "removeFirst() sollte danach 'B' zurückgeben.");
        assertEquals("A", list.removeFirst(), 
            "Zum Schluss sollte 'A' zurückgegeben werden.");
        assertEquals(0, list.size(), 
            "Jetzt sollte die Liste leer sein.");
    }

    @Test
    void testRemoveSpecificElement() {
        MyList<String> list = new MyList<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");

        assertTrue(list.remove("B"), 
            "remove(\"B\") sollte true zurückgeben, da 'B' vorhanden ist.");
        assertFalse(list.contains("B"), 
            "Nach dem Entfernen sollte 'B' nicht mehr in der Liste sein.");
        assertEquals(2, list.size(), 
            "Nach dem Entfernen von 'B' sollte die Größe 2 sein.");

        assertFalse(list.remove("Z"), 
            "remove(\"Z\") sollte false zurückgeben, da 'Z' nicht vorhanden ist.");
        assertEquals(2, list.size(), 
            "Die Größe sollte sich nicht ändern, wenn das Element nicht existierte.");
    }

    @Test
    void testRemoveHeadElement() {
        // Testet den Sonderfall, bei dem das erste Element entfernt wird,
        // ohne explizit removeFirst() aufzurufen.
        MyList<String> list = new MyList<>();
        list.insert("A");
        list.insert("B");

        assertTrue(list.remove("B"), 
            "Das kopfseitige Element 'B' sollte entfernt werden.");
        assertFalse(list.contains("B"), 
            "Nach dem Entfernen sollte 'B' nicht mehr enthalten sein.");
        assertEquals(1, list.size(), 
            "Die Liste sollte nun noch ein Element enthalten.");
        assertTrue(list.contains("A"), 
            "'A' sollte weiterhin in der Liste sein.");
    }

    @Test
    void testInsertNullValue() {
        MyList<String> list = new MyList<>();
        list.insert(null);
        assertEquals(0, list.size(), 
            "Ein null-Wert sollte nicht eingefügt werden; die Größe sollte 0 bleiben.");
    }
}