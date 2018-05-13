package kerra.games.engines.v1.tiles.ground;

import kerra.games.engines.v1.player.HumanPlayer;
import kerra.games.engines.v1.tiles.ground.Ground;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroundTest {

    private Ground ground = new Ground();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertTrue(ground.canEnter(player));
        ground.enter(player);
        assertFalse(ground.canEnter(player));
    }

    @Test
    void enter() {
        assertFalse(ground.isOccupied());
        ground.enter(player);
        assertTrue(ground.isOccupied());
    }

    @Test
    void leave() {
        ground.enter(player);
        ground.leave(player);
        assertFalse(ground.isOccupied());
    }

    @Test
    void isOccupied() {
        assertFalse(ground.isOccupied());
        ground.enter(player);
        assertTrue(ground.isOccupied());
    }

    @Test
    void toChar() {
        assertEquals('.', ground.toChar());
        ground.enter(player);
        assertEquals(player.toChar(), ground.toChar());
    }
}