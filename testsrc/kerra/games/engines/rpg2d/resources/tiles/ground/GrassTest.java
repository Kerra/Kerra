package kerra.games.engines.rpg2d.resources.tiles.ground;

import kerra.games.engines.rpg2d.players.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassTest {

    private Grass grass = new Grass(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertTrue(grass.canEnter(player));
        grass.enter(player);
        assertFalse(grass.canEnter(player));
    }

    @Test
    void enter() {
        assertFalse(grass.isOccupied());
        grass.enter(player);
        assertTrue(grass.isOccupied());
    }

    @Test
    void leave() {
        grass.enter(player);
        grass.leave(player);
        assertFalse(grass.isOccupied());
    }

    @Test
    void isOccupied() {
        assertFalse(grass.isOccupied());
        grass.enter(player);
        assertTrue(grass.isOccupied());
    }

    @Test
    void toChar() {
        assertEquals('#', grass.toChar());
        grass.enter(player);
        assertEquals(player.toChar(), grass.toChar());
    }
}