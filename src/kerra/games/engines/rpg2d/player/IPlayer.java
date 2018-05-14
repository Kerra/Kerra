package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.player.abilities.Ability;
import kerra.games.engines.rpg2d.player.properties.AProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface IPlayer {

    /**
     * Spawns this implementation of {@code IPlayer} in the specified {@link Area} at the specified position.
     *
     * @param area  the area to spawn in
     * @param x     the position x
     * @param y     the position y
     */
    public void spawn(@NotNull Area area, int x, int y);

    /**
     * Returns whether this implementation of {@code IPlayer} can move to the specified position.
     *
     * @param area  the area to move to
     * @param x     the position x
     * @param y     the position y
     * @return  {@code true} if this player can move<br>
     *          {@code false} otherwise
     */
    public boolean canMove(@NotNull Area area, int x, int y);

    /**
     * Orders this implementation of {@code IPlayer} to move.
     */
    public void move();

    /**
     * Gives the specified {@code ability} to this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be given
     */
    public void giveAbility(@NotNull Ability ability);

    /**
     * Removes the specified {@code ability} of this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be removed
     */
    public void removeAbility(@NotNull Ability ability);

    /**
     * Returns the abilities of this implementation of {@code IPlayer} as {@link ArrayList}.
     *
     * @return the abilities of this player
     */
    @NotNull
    public ArrayList<Ability> getAbilities();

    /**
     * Returns the properties of this implementation of {@code IPlayer} as {@link ArrayList}.
     *
     * @return the properties of this player
     */
    @NotNull
    public ArrayList<AProperty> getProperties();

    /**
     * Returns the Area this implementation of {@code IPlayer} is in.
     *
     * @return  the area of this player
     */
    public Area getArea();

    /**
     * Returns the position of this implementation of {@code IPlayer} as an array {@code [X, Y]}.
     *
     * @return  the position of this player
     */
    public int[] getPosition();

    /**
     * Returns a char representation of this implementation of {@code IPlayer}.
     *
     * @return a char representation
     */
    public char toChar();
}
