package kerra.games.engines.rpg2d.resources.tiles.water;

public class CoastBot extends Water {

    public CoastBot(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for bottom side of a coast.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '≃';
    }
}
