package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.Area.Area;
import kerra.games.engines.rpg2d.player.abilities.Ability;
import kerra.games.engines.rpg2d.player.properties.AProperty;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class APlayer implements IPlayer {

    private Area area;
    private ATile tile;
    private int X, Y;
    private ArrayList<Ability> abilities = new ArrayList<>(0);
    private ArrayList<AProperty> properties = new ArrayList<>(0);

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
     * Moves this implementation of {@code IPlayer} to the specified {@link Area} at the specified position.
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
        this.tile = area.getTiles()[Y][X];
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
     * Returns a char representation of this player.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '§';
    }
}
