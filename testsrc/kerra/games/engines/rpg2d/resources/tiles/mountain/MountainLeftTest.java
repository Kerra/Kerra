package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.players.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainLeftTest {

    private MountainLeft mountainLeft = new MountainLeft(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(mountainLeft.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('/', mountainLeft.toChar());
    }
}