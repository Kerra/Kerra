package kerra.games.engines.rpg2d.resources.tiles.water;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterTest {

    private Water water = new Water(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(water.canEnter(player));
        player.giveAbility(Swimming.getInstance());
        assertTrue(water.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('≈', water.toChar());
    }
}