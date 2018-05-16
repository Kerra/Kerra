package kerra.games.engines.rpg2d.events;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.Engine;
import kerra.games.engines.rpg2d.player.ScriptPlayer;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionTest {

    private Area area1 = new Area(5, 5) {
        public void fill() { fillGround(); }
    };

    private Area area2 = new Area(5, 5) {
        public void fill() { fillWater(); }
    };

    private String script = "113";
    private ScriptPlayer player;

    // Actions to teleport player
    private Action tp = new Action() {
        public void run() { ScriptPlayer.getInstance(script).moveTo(area2, 2, 2); }
    };
    private Action tp2 = new Action() {
        public void run() { ScriptPlayer.getInstance(script).moveTo(area1, 2, 3); }
    };

    // Action to give player the Swimming ability
    private Action giveSwimming = new Action() {
        public void run() {
            if (player.giveAbility(Swimming.getInstance()))
                System.out.println("The player got the ability \'" + Swimming.getInstance() + "\'!");
        }
    };

    // Conditions for teleport
    private Condition teleport = new Condition() {
        public boolean isMet() { return player.getAbilities().contains(Swimming.getInstance()); }
        public void run() { tp.run(); }
    };
    private Condition teleport2 = new Condition() {
        public boolean isMet() { return true; }
        public void run() { tp2.run(); }
    };

    // Condition to give Player the teleport
    private Condition giveAbility = new Condition() {
        public boolean isMet() { return true; }
        public void run() { giveSwimming.run(); }
    };

    // Driver to run
    private Engine engine = Engine.getInstance();

    @BeforeEach
    void setUp() {
        player = ScriptPlayer.getInstance(script);
        player.spawn(area1, 2, 3);
        area1.getTile(2, 2).setCondition(teleport);
        area1.getTile(2, 1).setCondition(giveAbility);
        area2.getTile(2, 1).setCondition(teleport2);
        engine.setPlayer(player);
        engine.setSteps(50);
        engine.setDelay(0);
    };

    @Test
    void run() {
        engine.run();
    }
}