package kerra.games.engines.rpg2d.events;

import kerra.games.engines.rpg2d.maps.Map;
import kerra.games.engines.rpg2d.Engine;
import kerra.games.engines.rpg2d.players.ScriptPlayer;
import kerra.games.engines.rpg2d.players.abilities.Swimming;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionTest {

    private Map map1 = new Map(5, 5) {
        public void fill() { fillGround(); }
    };

    private Map map2 = new Map(5, 5) {
        public void fill() { fillWater(); }
    };

    private String script = "113";
    private ScriptPlayer player;

    // Actions to teleport players
    private Action tp = new Action() {
        public void run() { ScriptPlayer.getInstance(script).moveTo(map2, 2, 2); }
    };
    private Action tp2 = new Action() {
        public void run() { ScriptPlayer.getInstance(script).moveTo(map1, 2, 3); }
    };

    // Action to give players the Swimming ability
    private Action giveSwimming = new Action() {
        public void run() {
            if (player.giveAbility(Swimming.getInstance()))
                System.out.println("The players got the ability \'" + Swimming.getInstance() + "\'!");
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
        player.spawn(map1, 2, 3);
        map1.getTile(2, 2).setCondition(teleport);
        map1.getTile(2, 1).setCondition(giveAbility);
        map2.getTile(2, 1).setCondition(teleport2);
        engine.setPlayer(player);
        engine.setSteps(50);
        engine.setDelay(0);
    };

    @Test
    void run() {
        engine.run();
    }
}