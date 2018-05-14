package kerra.games.engines.rpg2d.condition;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.Driver;
import kerra.games.engines.rpg2d.action.Action;
import kerra.games.engines.rpg2d.player.ScriptPlayer;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        public void run() { player.giveAbility(Swimming.getInstance()); }
    };


    // Conditions for teleport
    private Condition teleport = new Condition() {
        public boolean ask() { return player.getAbilities().contains(Swimming.getInstance()); }
        public @NotNull Action getAction() { return tp; }
    };
    private Condition teleport2 = new Condition() {
        public boolean ask() { return true; }
        public @NotNull Action getAction() { return tp2; }
    };

    // Condition to give Player the teleport
    private Condition giveAbility = new Condition() {
        public boolean ask() { return true; }
        public @NotNull Action getAction() { return giveSwimming; }
    };



    private Driver driver = new Driver() {

        @Override
        public void setUp() {
            player = ScriptPlayer.getInstance(script);
            player.spawn(area1, 2, 3);
            area1.getTile(2, 2).setCondition(teleport);
            area1.getTile(2, 1).setCondition(giveAbility);
            area2.getTile(2, 1).setCondition(teleport2);
            setPlayer(player);
        }
    };


    @Test
    void run() {
        driver.run();
    }
}