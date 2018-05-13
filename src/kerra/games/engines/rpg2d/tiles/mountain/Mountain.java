package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.IPlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class Mountain extends ATile {

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
