package kerra.games.engines.rpg2d.player.abilities;

public class Swimming {
    private static Swimming ourInstance = new Swimming();

    public static Swimming getInstance() {
        return ourInstance;
    }

    private Swimming() {
    }
}
