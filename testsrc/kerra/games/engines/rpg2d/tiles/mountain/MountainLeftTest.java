package kerra.games.engines.v1.tiles.mountain;

import kerra.games.engines.v1.player.HumanPlayer;
import kerra.games.engines.v1.tiles.mountain.MountainLeft;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainLeftTest {

    private MountainLeft mountainLeft = new MountainLeft();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(mountainLeft.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('/', mountainLeft.toChar());
    }
}