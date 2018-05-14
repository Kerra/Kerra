package kerra.games.engines.rpg2d.player.abilities;

import org.jetbrains.annotations.NotNull;

public class Strength extends Ability {
    private static Strength ourInstance = new Strength();

    public static Strength getInstance() {
        return ourInstance;
    }

    private Strength() {
    }

    @NotNull
    @Override
    public String toString() {
        return "Strength";
    }
}
