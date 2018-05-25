package kerra.games.engines.rpg2d.players.abilities;

import org.jetbrains.annotations.NotNull;

public class Swimming extends Ability {
    private static Swimming ourInstance = new Swimming();

    public static Swimming getInstance() {
        return ourInstance;
    }

    private Swimming() {
    }

    @NotNull
    @Override
    public String toString() {
        return "Swimming";
    }
}
