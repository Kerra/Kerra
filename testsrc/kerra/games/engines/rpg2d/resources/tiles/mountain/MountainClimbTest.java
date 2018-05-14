package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import kerra.games.engines.rpg2d.player.abilities.Climbing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainClimbTest {

    private MountainClimb mountainClimb = new MountainClimb(0, 0);
    private HumanPlayer player = HumanPlayer.getInstance();

    @Test
    void canEnter() {
        assertFalse(mountainClimb.canEnter(player));
        player.giveAbility(Climbing.getInstance());
        assertTrue(mountainClimb.canEnter(player));
    }

    @Test
    void toChar() {
        assertEquals('¦', mountainClimb.toChar());
    }
}