package kerra.games.engines.rpg2d.maps;

import kerra.games.engines.rpg2d.tiles.ATile;
import kerra.games.engines.rpg2d.resources.tiles.ground.Ground;
import kerra.games.engines.rpg2d.resources.tiles.ground.Rock;
import kerra.games.engines.rpg2d.resources.tiles.mountain.Mountain;
import kerra.games.engines.rpg2d.resources.tiles.water.Water;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public abstract class Map {

    protected ATile[][] area;

    public Map(int xSize, int ySize) {
        this.area = new ATile[ySize][xSize];
        fill();
    }

    public abstract void fill();

    /**
     * Fills this maps with {@link Ground} tiles.
     */
    public void fillGround() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Ground(x, y);
    }

    /**
     * Fills this maps with {@link Mountain} tiles.
     */
    public void fillMountain() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Mountain(x, y);
    }

    /**
     * Fills this maps with {@link Rock} tiles.
     */
    public void fillRock() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Rock(x, y);
    }

    /**
     * Fills this maps with {@link Water} tiles.
     */
    public void fillWater() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Water(x, y);
    }

    /**
     * Returns the tile at the specified position
     *
     * @param x the position x
     * @param y the position y
     * @return the tile at specified position
     */
    @NotNull
    public ATile getTile(int x, int y) {
        int X = Math.max(Math.min(x, area[0].length-1), 0);   // catching out of bounds
        int Y = Math.max(Math.min(y, area.length-1), 0);      // catching out of bounds
        return this.area[Y][X];
    }

    /**
     * Returns the tile layout of this maps.
     *
     * @return the tiles of this maps
     */
    @NotNull
    public ATile[][] getTiles() {
        return this.area;
    }


    /**
     * Returns the size (amount of tiles) of this maps.
     *
     * @return amount of tiles
     */
    public int size() {
        return area.length * area[0].length;
    }

    /**
     * Returns a copy of all tiles
     *
     * @return copy of all tiles
     */
    public ATile[][] getCopy() {
        return new Map(Map.this.area.length, Map.this.area[0].length) {
            public void fill() {
                Map.this.fill();
            }
        }.getTiles();
    }

    /**
     * Returns a String representation of this maps using {@link ATile#toChar()} for each tile.
     *
     * @return a string representation
     */
    @NotNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ATile[] row : area) {
            for (ATile x : row) s.append(x.toChar()).append(" ");
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Returns the name of this maps.
     * By default, this returns the name of the class.
     *
     * @return name of the maps
     */
    @NotNull
    public String getName() {
        return getClass().getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) return false;
        Map a = (Map) obj;
        return Arrays.deepEquals(a.getTiles(), getTiles());
    }
}
