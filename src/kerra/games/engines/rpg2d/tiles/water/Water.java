package kerra.games.engines.rpg2d.tiles.water;

import kerra.games.engines.rpg2d.player.IPlayer;
import kerra.games.engines.rpg2d.player.abilities.Swimming;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class Water extends ATile {

    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player the player wanting to enter
     * @return {@code true} if the player may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return player.getAbilities().contains(Swimming.getInstance());
    }

    /**
     * Returns a {@code char} representation for water.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '≈';
    }
}
