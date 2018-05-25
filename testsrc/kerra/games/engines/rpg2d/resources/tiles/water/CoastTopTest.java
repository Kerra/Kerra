package kerra.games.engines.rpg2d.resources.tiles.water;

import kerra.games.engines.rpg2d.players.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoastTopTest {

    private CoastTop coast = new CoastTop(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(coast.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('¬', coast.toChar());
    }
}