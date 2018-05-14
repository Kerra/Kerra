package kerra.games.engines.rpg2d.resources.tiles.mountain;

public class MountainTop extends Mountain {

    public MountainTop(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the top side of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return  '_';
    }
}
