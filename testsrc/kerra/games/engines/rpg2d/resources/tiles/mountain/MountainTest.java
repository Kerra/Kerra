package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainTest {

    private Mountain mountain = new Mountain();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(mountain.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('^', mountain.toChar());
    }
}