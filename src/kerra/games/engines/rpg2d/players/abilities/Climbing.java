package kerra.games.engines.rpg2d.players.abilities;

import org.jetbrains.annotations.NotNull;

public class Climbing extends Ability {
    private static Climbing ourInstance = new Climbing();

    public static Climbing getInstance() {
        return ourInstance;
    }

    private Climbing() {
    }

    @NotNull
    @Override
    public String toString() {
        return "Climbing";
    }
}
