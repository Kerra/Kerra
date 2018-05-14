package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScriptPlayerTest {

    private String script = "112233444444222";

    private Area area = new Area(5, 5) {
        @Override
        public void fill() {
            fillGround();
        }};

    private ScriptPlayer player;

    @BeforeEach
    void setUp() {
        player = ScriptPlayer.getInstance(script);
    }

    @Test
    void spawn() {
        player.spawn(area, 1, 3);
        print();
    }

    @Test
    void move() {
        spawn();
        for (int i=0; i<script.length(); i++) {
            player.move();
            print();
        }
    }

    @Test
    void giveAbility() {
        player.giveAbility(Swimming.getInstance());
        assertTrue(player.getAbilities ().contains(Swimming.getInstance()));
    }

    @Test
    void removeAbility() {
        player.giveAbility(Swimming.getInstance());
        player.removeAbility(Swimming.getInstance());
        assertFalse(player.getAbilities().contains(Swimming.getInstance()));
    }

    @Test
    void getAbilities() {
        player.removeAbility(Swimming.getInstance());
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
        assertEquals('S', player.toChar());
    }

    private void print() {
        System.out.println(area.toString());
    }
}