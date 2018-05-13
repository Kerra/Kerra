package kerra.games.engines.rpg2d.player.abilities;

public class Climbing {
    private static Climbing ourInstance = new Climbing();

    public static Climbing getInstance() {
        return ourInstance;
    }

    private Climbing() {
    }
}
