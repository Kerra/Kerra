package kerra.games.engines.rpg2d.players;

import kerra.games.engines.rpg2d.maps.Map;
import kerra.games.engines.rpg2d.players.abilities.Ability;
import kerra.games.engines.rpg2d.players.properties.AProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface IPlayer {

    /**
     * Spawns this implementation of {@code IPlayer} in the specified {@link Map} at the specified position.
     *
     * @param map  the maps to spawn in
     * @param x     the position x
     * @param y     the position y
     */
    public void spawn(@NotNull Map map, int x, int y);

    /**
     * Returns whether this implementation of {@code IPlayer} can move to the specified position.
     *
     * @param map  the maps to move to
     * @param x     the position x
     * @param y     the position y
     * @return  {@code true} if this players can move<br>
     *          {@code false} otherwise
     */
    public boolean canMove(@NotNull Map map, int x, int y);

    /**
     * Orders this implementation of {@code IPlayer} to move.
     */
    public void move();

    /**
     * Gives the specified {@code ability} to this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be given
     * @return {@code true} if successfully added.
     *         {@code false} if already present.
     */
    public boolean giveAbility(@NotNull Ability ability);

    /**
     * Removes the specified {@code ability} of this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be removed
     * @return {@code true} if successfully removed.
     *         {@code false} if already removed.
     */
    public boolean removeAbility(@NotNull Ability ability);

    /**
     * Returns the abilities of this implementation of {@code IPlayer} as {@link ArrayList}.
     *
     * @return the abilities of this players
     */
    @NotNull
    public ArrayList<Ability> getAbilities();

    /**
     * Returns the properties of this implementation of {@code IPlayer} as {@link ArrayList}.
     *
     * @return the properties of this players
     */
    @NotNull
    public ArrayList<AProperty> getProperties();

    /**
     * Returns the Map this implementation of {@code IPlayer} is in.
     *
     * @return  the maps of this players
     */
    public Map getMap();

    /**
     * Returns the position of this implementation of {@code IPlayer} as an array {@code [X, Y]}.
     *
     * @return  the position of this players
     */
    public int[] getPosition();

    /**
     * Returns a char representation of this implementation of {@code IPlayer}.
     *
     * @return a char representation
     */
    public char toChar();
}
