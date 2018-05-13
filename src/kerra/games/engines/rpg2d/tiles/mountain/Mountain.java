package kerra.games.engines.rpg2d.tiles.mountain;

import kerra.games.engines.rpg2d.player.IPlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class MountainGround extends ATile {

    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player the player wanting to enter
     * @return {@code true} if the player may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return !isOccupied();
    }

    /**
     * Returns a {@code char} representation for the ground of a mountain.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return isOccupied() ? player.toChar() : '^';
    }
}
