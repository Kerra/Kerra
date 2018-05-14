package kerra.games.engines.rpg2d.resources.tiles.water;

public class CoastTop extends Water {

    public CoastTop(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the top side of a coast.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '¬';
    }
}
