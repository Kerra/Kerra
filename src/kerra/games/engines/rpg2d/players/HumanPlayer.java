package kerra.games.engines.rpg2d.players;

public class HumanPlayer extends APlayer {

    private static HumanPlayer ourInstance = new HumanPlayer();

    public static HumanPlayer getInstance() {
        return ourInstance;
    }

    private HumanPlayer() { }

    /**
     * Orders the human players to move.
     */
    @Override
    public void move() {

    }
}
