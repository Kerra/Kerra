package kerra.games.engines.rpg2d.resources.tiles.mountain;

public class MountainLeft extends Mountain{

    public MountainLeft(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the left side of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '/';
    }
}
