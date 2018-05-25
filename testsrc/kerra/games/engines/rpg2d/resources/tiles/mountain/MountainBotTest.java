package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.players.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainBotTest {

    private MountainBot mountainBot = new MountainBot(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(mountainBot.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('|', mountainBot.toChar());
    }
}