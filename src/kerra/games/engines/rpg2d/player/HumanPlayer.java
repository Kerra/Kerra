package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.resources.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class HumanPlayer extends APlayer {

    private static HumanPlayer ourInstance = new HumanPlayer();

    public static HumanPlayer getInstance() {
        return ourInstance;
    }

    private HumanPlayer() { }

    /**
     * Orders the human player to move.
     */
    @Override
    public void move() {

    }
}
