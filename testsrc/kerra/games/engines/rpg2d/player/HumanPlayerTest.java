package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.player.abilities.Ability;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    private HumanPlayer player;

    @BeforeEach
    void setUp() {
        player = new HumanPlayer();
    }

    @Test
    void spawn() {

    }

    @Test
    void giveAbility() {
        player.giveAbility(Swimming.getInstance());
        for (Ability a : player.getAbilities()) System.out.println(a);
    }

    @Test
    void getAbilities() {
        assertEquals(0, player.getAbilities().size());

        player.giveAbility(Swimming.getInstance());
        assertTrue(player.getAbilities().contains(Swimming.getInstance()));
        assertEquals(1, player.getAbilities().size());
    }

    @Test
    void getProperties() {
    }

    @Test
    void toChar() {
        assertEquals('§', player.toChar());
    }
}