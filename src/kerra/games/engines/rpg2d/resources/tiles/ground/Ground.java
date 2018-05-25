package kerra.games.engines.rpg2d.resources.tiles.ground;

import kerra.games.engines.rpg2d.players.IPlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class Ground extends ATile {

    public Ground(int x, int y) {
        super(x, y);
    }

    /**
     * Returns {@code true} if the specified players can enter this tile.
     *
     * @param player the players wanting to enter
     * @return {@code true} if the players may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return !isOccupied();
    }

    /**
     * Returns a {@code char} representation for normal ground.
     *
     * @return  a char representation
     */
    @Override
    public char toChar() {
        return isOccupied() ? player.toChar() : '.';
    }
}
