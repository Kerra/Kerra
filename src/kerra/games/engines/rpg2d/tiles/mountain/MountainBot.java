package kerra.games.engines.v1.tiles.mountain;

import kerra.games.engines.v1.player.IPlayer;
import kerra.games.engines.v1.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class MountainBot extends ATile {

    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player the player wanting to enter
     * @return {@code true} if the player may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return false;
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
