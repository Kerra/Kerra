package kerra.games.engines.v1.tiles.mountain;

import kerra.games.engines.v1.player.HumanPlayer;
import kerra.games.engines.v1.tiles.mountain.MountainRight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainRightTest {

    private MountainRight mountainRight = new MountainRight();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(mountainRight.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('\\', mountainRight.toChar());
    }
}