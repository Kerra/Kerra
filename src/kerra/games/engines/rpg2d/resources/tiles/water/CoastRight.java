package kerra.games.engines.rpg2d.resources.tiles.water;

public class CoastRight extends Water {

    public CoastRight(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the right side of a coast.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '{';
    }
}
