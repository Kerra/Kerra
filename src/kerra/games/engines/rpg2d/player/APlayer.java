package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.player.abilities.Ability;
import kerra.games.engines.rpg2d.player.properties.AProperty;
import kerra.games.engines.rpg2d.resources.tiles.ATile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class APlayer implements IPlayer {

    protected Area area;
    protected ATile tile;
    protected int X, Y;
    protected ArrayList<Ability> abilities = new ArrayList<>(0);
    protected ArrayList<AProperty> properties = new ArrayList<>(0);

    /**
     * Spawns this implementation of {@code IPlayer} in the specified {@link Area} at the specified position.
     *
     * @param area  the area to spawn in
     * @param x     the position x
     * @param y     the position y
     */
    public void spawn(@NotNull Area area, int x, int y) {
        this.area = area;
        this.X = x;
        this.Y = y;
        this.tile = area.getTiles()[Y][X];
        this.tile.enter(this);
    }

    /**
     * Returns whether this implementation of {@code IPlayer} can move to the specified position.
     *
     * @param area  the area to move to
     * @param x     the position x
     * @param y     the position y
     * @return  {@code true} if this player can move<br>
     *          {@code false} otherwise
     */
    public boolean canMove(@NotNull Area area, int x, int y) {
        return area.getTiles()[y][x].canEnter(this);
    }

    /**
     * Orders this implementation of {@code IPlayer} to move.
     * Must be implemented by subclasses.<br>
     */
    public abstract void move();

    /**
     * Moves this player to the specified {@link Area} at the specified position.
     *
     * @param area  the area to move to
     * @param x     the position x
     * @param y     the position y
     */
    public void moveTo(@NotNull Area area, int x, int y) {
        this.area = area;
        this.X = x;
        this.Y = y;
        this.tile.leave(this);
        this.tile = area.getTiles()[y][x];
        this.tile.enter(this);
    }



    /**
     * Gives the specified {@code ability} to this player.
     *
     * @param ability   the ability to be given.
     */
    @Override
    public void giveAbility(@NotNull Ability ability) {
        if (!abilities.contains(ability)) abilities.add(ability);
    }

    /**
     * Gives the specified {@code ability} to this implementation of {@code IPlayer}.
     *
     * @param ability   the ability to be given
     */
    @Override
    public void removeAbility(@NotNull Ability ability) {
        abilities.remove(ability);
    }

    /**
     * Returns the abilities of this player as {@link ArrayList}.
     *
     * @return the abilities of this player
     */
    @NotNull
    @Override
    public ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    /**
     * Returns the properties of this player as {@link ArrayList}.
     *
     * @return the properties of this player
     */
    @NotNull
    @Override
    public ArrayList<AProperty> getProperties() {
        return this.properties;
    }

    /**
     * Returns the Area this implementation of {@code IPlayer} is in.
     *
     * @return  the area of this player
     */
    @NotNull
    @Override
    public Area getArea() {
        return this.area;
    }

    /**
     * Returns the position of this implementation of {@code IPlayer} as an array {@code [X, Y]}.
     *
     * @return the position of this player
     */
    @Override
    public int[] getPosition() {
        return new int[]{X, Y};
    }

    /**
     * @return  the position X of this player
     */
    public int getX() {
        return this.X;
    }

    /**
     * @return  the position Y of this player
     */
    public int getY() {
        return this.Y;
    }

    /**
     * Returns the {@code ATile} this implementation of {@code APlayer} is currently in.
     *
     * @return  the current tile of this player
     */
    public ATile getTile() {
        return this.tile;
    }

    /**
     * Returns the char representation {@code 'P'} of this player.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return 'P';
    }
}
