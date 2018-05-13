package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
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