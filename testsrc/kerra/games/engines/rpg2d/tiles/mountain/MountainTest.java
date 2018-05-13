package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainGroundTest {

    private MountainGround mountainGround = new MountainGround();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertTrue(mountainGround.canEnter(player));
        mountainGround.enter(player);
        assertFalse(mountainGround.canEnter(player));
    }

    @Test
    void enter() {
        assertFalse(mountainGround.isOccupied());
        mountainGround.enter(player);
        assertTrue(mountainGround.isOccupied());
    }

    @Test
    void leave() {
        mountainGround.enter(player);
        mountainGround.leave(player);
        assertFalse(mountainGround.isOccupied());
    }

    @Test
    void isOccupied() {
        assertFalse(mountainGround.isOccupied());
        mountainGround.enter(player);
        assertTrue(mountainGround.isOccupied());
    }

    @Test
    void toChar() {
        assertEquals('^', mountainGround.toChar());
        mountainGround.enter(player);
        assertEquals(player.toChar(), mountainGround.toChar());
    }
}