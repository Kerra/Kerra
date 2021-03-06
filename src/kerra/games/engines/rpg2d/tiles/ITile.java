package kerra.games.engines.rpg2d.tiles;

import kerra.games.engines.rpg2d.players.IPlayer;
import org.jetbrains.annotations.NotNull;

public interface ITile {

    /**
     * Returns {@code true} if the specified players can enter this tile.
     *
     * @param player    the players wanting to enter
     * @return  {@code true} if the players may enter.<br>
     *          {@code false} otherwise
     */
    public boolean canEnter(@NotNull IPlayer player);

    /**
     * Makes the specified players enter this tile as long as he can.
     * This method should call {@link #canEnter(IPlayer)} first!
     *
     * @param player    the players to enter
     */
    public void enter(@NotNull IPlayer player);

    /**
     * Makes the specified players leave this tile.
     *
     * @param player    the players to leave
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
     * Returns the position of this implementation of {@code ITile} as an array {@code [X, Y]}.
     *
     * @return the position of this tile
     */
    public int[] getPosition();

    /**
     * Returns a {@code char} representation of this implementation of {@code ITile}.
     *
     * @return  a char representation
     */
    public char toChar();
}
