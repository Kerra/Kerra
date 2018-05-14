package kerra.games.engines.rpg2d.resources.tiles.mountain;

public class MountainRight extends Mountain {

    public MountainRight(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the right side of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '\\';
    }
}
