package kerra.games.engines.v1.player;

public class HumanPlayer implements IPlayer {
    /**
     * Returns a char representation of this implementation of {@code IPlayer}.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '§';
    }
}
