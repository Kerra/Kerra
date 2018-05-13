package kerra.games.engines.v1.tiles.mountain;

import kerra.games.engines.v1.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainBotTest {

    private MountainBot mountainBot = new MountainBot();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(mountainBot.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('|', mountainBot.toChar());
    }
}