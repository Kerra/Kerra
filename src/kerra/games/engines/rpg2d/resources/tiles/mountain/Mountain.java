package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.player.IPlayer;
import kerra.games.engines.rpg2d.resources.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class Mountain extends ATile {

    public Mountain(int x, int y) {
        super(x, y);
    }

    /**
     * Returns {@code false}.
     *
     * @param player the player wanting to enter
     * @return {@code false}
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return false;
    }

    /**
     * Returns a {@code char} representation for the ground of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '^';
    }
}
