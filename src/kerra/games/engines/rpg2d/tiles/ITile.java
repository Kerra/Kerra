package kerra.games.engines.rpg2d.tiles;

import kerra.games.engines.rpg2d.player.IPlayer;
import org.jetbrains.annotations.NotNull;

public interface ITile {

    /**
     * Returns {@code true} if the specified player can enter this tile.
     *
     * @param player    the player wanting to enter
     * @return  {@code true} if the player may enter.<br>
     *          {@code false} otherwise
     */
    public boolean canEnter(@NotNull IPlayer player);

    /**
     * Makes the specified player enter this tile as long as he can.
     * This method should call {@link #canEnter(IPlayer)} first!
     *
     * @param player    the player to enter
     */
    public void enter(@NotNull IPlayer player);

    /**
     * Makes the specified player leave this tile.
     *
     * @param player    the player to leave
     */
    public void leave(@NotNull IPlayer player);

    /**
     * Returns {@code true} if this tile is occupied.
     *
     * @return  {@code true} if occupied.<br>
     *          {@code false} otherwise
     */
    public boolean isOccupied();

    /**
     * Returns a {@code char} representation of this implementation of {@code ITile}.
     *
     * @return  a char representation
     */
    public char toChar();
}
