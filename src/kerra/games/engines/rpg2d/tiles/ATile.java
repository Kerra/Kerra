package kerra.games.engines.v1.tiles;

import kerra.games.engines.v1.player.IPlayer;
import org.jetbrains.annotations.NotNull;

public abstract class ATile implements ITile {

    protected IPlayer player;



    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player the player wanting to enter
     * @return {@code true} if the player may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public abstract boolean canEnter(@NotNull IPlayer player);

    /**
     * Makes the specified player enter this tile as long as he can.
     * This method should call {@link #canEnter(IPlayer)} first!
     *
     * @param player the player to enter
     */
    @Override
    public void enter(@NotNull IPlayer player) {
        assert canEnter(player);
        this.player = player;
    }

    /**
     * Makes the specified player leave this tile.
     *
     * @param player the player to leave
     */
    @Override
    public void leave(@NotNull IPlayer player) {
        assert this.player != null;
        this.player = null;
    }

    /**
     * Returns {@code true} if this tile is occupied.
     *
     * @return {@code true} if occupied.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean isOccupied() {
        return this.player != null;
    }

    /**
     * Returns a {@code char} representation of this implementation of {@code ITile}.
     *
     * @return a char representation
     */
    @Override
    public abstract char toChar();


    /**
     * Returns {@link #toChar()} as a {@code String}.
     *
     * @return  the string representation of {@code toChar()}
     */
    @Override
    public String toString() {
        return String.valueOf(toChar());
    }
}
