package kerra.games.engines.rpg2d.tiles;

import kerra.games.engines.rpg2d.player.IPlayer;
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
        if (!canEnter(player)) throw new AssertionError("Player cannot enter!");
        this.player = player;
    }

    /**
     * Makes the specified player leave this tile.
     *
     * @param player the player to leave
     */
    @Override
    public void leave(@NotNull IPlayer player) {
        if (this.player == null) throw new AssertionError("Current player not null!");
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
