package kerra.games.engines.rpg2d.tiles.ground;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockTest {

    private Rock rock = new Rock();
    private HumanPlayer player = new HumanPlayer();

    @Test
    void canEnter() {
        assertFalse(rock.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('&', rock.toChar());
    }
}