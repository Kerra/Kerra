package kerra.games.engines.rpg2d.resources.tiles.mountain;

public class MountainBot extends Mountain {

    public MountainBot(int x, int y) {
        super(x, y);
    }

    /**
     * Returns a {@code char} representation for the bottom of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '|';
    }
}
