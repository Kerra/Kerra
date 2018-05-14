package kerra.games.engines.rpg2d.tiles.water;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoastBotTest {

    private CoastBot coast = new CoastBot();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(coast.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('≃', coast.toChar());
    }
}