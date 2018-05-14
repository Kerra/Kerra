package kerra.games.engines.rpg2d.resources.tiles.water;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoastBotTest {

    private CoastBot coast = new CoastBot(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(coast.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('≃', coast.toChar());
    }
}