package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.HumanPlayer;
import kerra.games.engines.rpg2d.player.abilities.Climbing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MountainClimbTest {

    private MountainClimb mountainClimb = new MountainClimb();
    private HumanPlayer player = new HumanPlayer();

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