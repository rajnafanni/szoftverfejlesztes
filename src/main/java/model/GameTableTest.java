package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTableTest {

    private GameTable gameTable;

    @Before
    public void setUp() {
        gameTable = new GameTable();
    }

    @Test
    public void testInitialization() {
        //A tábla helyes elkészítésénének ellenőrzése
        assertEquals(14, gameTable.SIZE);
        assertNotNull(gameTable.getPlayer());
        assertEquals(3, gameTable.getPlayer().getRow());
        assertEquals(0, gameTable.getPlayer().getCol());
    }

    @Test
    public void testMovePlayerToValidPosition() {
        gameTable.movePlayerTo(3, 1);
        assertEquals(3, gameTable.getPlayer().getRow());
        assertEquals(1, gameTable.getPlayer().getCol());
    }

    @Test
    public void testMovePlayerToInvalidPosition() {
        gameTable.movePlayerTo(0, 0); // fal
        assertEquals(3, gameTable.getPlayer().getRow());
        assertEquals(0, gameTable.getPlayer().getCol());

        gameTable.movePlayerTo(2, 0); // már volt ott
        assertEquals(3, gameTable.getPlayer().getRow());
        assertEquals(0, gameTable.getPlayer().getCol());
    }

    @Test
    public void testCanMoveToValidPosition() {
        // Ellenőrizzük, hogy a játékos mozoghat-e az adott helyre
        assertTrue(gameTable.canMoveTo(3, 1)); // szabad terület
    }

    @Test
    public void testCanMoveToInvalidPosition() {
        // Ellenőrizzük, hogy a játékos nem tud olyan helyre mozogni, ami fal vagy már volt ott
        assertFalse(gameTable.canMoveTo(0, 0)); // fal
        assertFalse(gameTable.canMoveTo(2, 0)); // már volt ott
    }

    @Test
    public void testGetValueAt() {
        // Ellenőrizzük, hogy a megadott sor és oszlop értéke helyes-e
        assertEquals(1, gameTable.getValueAt(0, 0)); // fal
        assertEquals(2, gameTable.getValueAt(3, 0)); // start
        assertEquals(3, gameTable.getValueAt(10, 13)); // cél
        assertEquals(0, gameTable.getValueAt(5, 5)); // alap
    }
}
