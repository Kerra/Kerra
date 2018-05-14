package kerra.games.engines.rpg2d.resources.tiles.water;

public class CoastLeft extends Water {

    public CoastLeft(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the left side of a coast.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '}';
    }
}
