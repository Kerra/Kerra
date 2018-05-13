package kerra.games.engines.rpg2d.tiles.ground;

import kerra.games.engines.rpg2d.player.IPlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class Grass extends ATile {

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
     * Returns a {@code char} representation for normal grass.
     *
     * @return  a char representation
     */
    @Override
    public char toChar() {
        return isOccupied() ? player.toChar() : '#';
    }
}
