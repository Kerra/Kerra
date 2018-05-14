package kerra.games.engines.rpg2d.resources.tiles.ground;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockTest {

    private Rock rock = new Rock(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(rock.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('0', rock.toChar());
    }
}