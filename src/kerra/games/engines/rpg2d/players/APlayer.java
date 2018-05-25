package kerra.games.engines.rpg2d.players;

import kerra.games.engines.rpg2d.maps.Map;
import kerra.games.engines.rpg2d.players.abilities.Ability;
import kerra.games.engines.rpg2d.players.properties.AProperty;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class APlayer implements IPlayer {

    protected Map map;
    protected ATile tile;
    protected int X, Y;
    protected ArrayList<Ability> abilities = new ArrayList<>(0);
    protected ArrayList<AProperty> properties = new ArrayList<>(0);

    /**
     * Spawns this implementation of {@code APlayer} in the specified {@link Map} in the specified {@link ATile}-
     *
     * @param map   the map the tile is in
     * @param spawn the tile to spawn
     */
    public final void spawn(@NotNull Map map, @NotNull ATile spawn) {
        if (Arrays.stream(map.getTiles()).flatMap(Arrays::stream).noneMatch(i -> i.equals(spawn)))
            throw new IllegalArgumentException("Specified spawn not in specified map!");
        this.spawn(map, spawn.getPosition()[0], spawn.getPosition()[1]);
    }

    /**
     * Spawns this implementation of {@code IPlayer} in the specified {@link Map} at the specified position.
     *
     * @param map  the maps to spawn in
     * @param x     the position x
     * @param y     the position y
     */
    public final void spawn(@NotNull Map map, int x, int y) {
        if (tile != null) throw new IllegalAccessError("Player already spawned!");
        this.map = map;
        this.X = x;
        this.Y = y;
        this.tile = map.getTiles()[Y][X];
        this.tile.enter(this);
    }

    /**
     * Returns whether this implementation of {@code IPlayer} can move to the specified position.
     *
     * @param map  the maps to move to
     * @param x     the position x
     * @param y     the position y
     * @return  {@code true} if this players can move<br>
     *          {@code false} otherwise
     */
    public final boolean canMove(@NotNull Map map, int x, int y) {
        return map.getTiles()[y][x].canEnter(this);
    }

    /**
     * Orders this implementation of {@code IPlayer} to move.
     * Must be implemented by subclasses.<br>
     */
    public abstract void move();

    public final void moveTo(@NotNull ATile target) {
        if (Arrays.stream(map.getTiles()).flatMap(Arrays::stream).noneMatch(i -> i.equals(target)))
            throw new IllegalArgumentException("Specified tile not in current map!");
        moveTo(map, target.getPosition()[0], target.getPosition()[1]);
    }

    /**
     * Moves this players to the specified {@link Map} at the specified position.
     *
     * @param map  the maps to move to
     * @param x     the position x
     * @param y     the position y
     */
    public final void moveTo(@NotNull Map map, int x, int y) {
        this.map = map;
        this.X = x;
        this.Y = y;
        this.tile.leave(this);
        this.tile = map.getTiles()[y][x];
        this.tile.enter(this);
    }



    /**
     * Gives the specified {@code ability} to this players.
     *
     * @param ability   the ability to be given.
     */
    @Override
    public final boolean giveAbility(@NotNull Ability ability) {
        if (!abilities.contains(ability)) {
            abilities.add(ability);
            return true;
        }
        return false;
    }

    /**
     * Gives the specified {@code ability} to this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be given
     */
    @Override
    public final boolean removeAbility(@NotNull Ability ability) {
        return abilities.remove(ability);
    }

    /**
     * Returns the abilities of this players as {@link ArrayList}.
     *
     * @return the abilities of this players
     */
    @NotNull
    @Override
    public final ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    /**
     * Returns the properties of this players as {@link ArrayList}.
     *
     * @return the properties of this players
     */
    @NotNull
    @Override
    public final ArrayList<AProperty> getProperties() {
        return this.properties;
    }

    /**
     * Returns the Map this implementation of {@code IPlayer} is in.
     *
     * @return  the maps of this players
     */
    @NotNull
    @Override
    public final Map getMap() {
        return this.map;
    }

    /**
     * Returns the position of this implementation of {@code IPlayer} as an array {@code [X, Y]}.
     *
     * @return the position of this players
     */
    @Override
    public final int[] getPosition() {
        return new int[]{X, Y};
    }

    /**
     * @return  the position X of this players
     */
    public final int getX() {
        return this.X;
    }

    /**
     * @return  the position Y of this players
     */
    public int getY() {
        return this.Y;
    }

    /**
     * Returns the {@code ATile} this implementation of {@code APlayer} is currently in.
     *
     * @return  the current tile of this players
     */
    public ATile getTile() {
        return this.tile;
    }

    /**
     * Returns the char representation {@code 'P'} of this players.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return 'P';
    }
}
