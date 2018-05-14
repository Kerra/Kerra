package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainRightTest {

    private MountainRight mountainRight = new MountainRight(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(mountainRight.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('\\', mountainRight.toChar());
    }
}