package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.players.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainTest {

    private Mountain mountain = new Mountain(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(mountain.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('^', mountain.toChar());
    }
}