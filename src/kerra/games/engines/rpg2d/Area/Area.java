package kerra.games.engines.rpg2d.Area;

import kerra.games.engines.rpg2d.resources.tiles.ATile;
import kerra.games.engines.rpg2d.resources.tiles.ground.Ground;
import kerra.games.engines.rpg2d.resources.tiles.ground.Rock;
import kerra.games.engines.rpg2d.resources.tiles.mountain.Mountain;
import kerra.games.engines.rpg2d.resources.tiles.water.Water;
import org.jetbrains.annotations.NotNull;

public abstract class Area {

    protected ATile[][] area;

    public Area(int xSize, int ySize) {
        this.area = new ATile[ySize][xSize];
        fill();
    }

    public abstract void fill();

    /**
     * Fills this area with {@link Ground} tiles.
     */
    public void fillGround() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Ground(x, y);
    }

    /**
     * Fills this area with {@link Mountain} tiles.
     */
    public void fillMountain() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Mountain(x, y);
    }

    /**
     * Fills this area with {@link Rock} tiles.
     */
    public void fillRock() {
        for (int y=0; y<area.length; y++)
            for (int x=0; x<area[0].length; x++)
                area[y][x] = new Rock(x, y);
    }

    /**
     * Fills this area with {@link Water} tiles.
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
     * Returns the tile layout of this area.
     *
     * @return the tiles of this area
     */
    @NotNull
    public ATile[][] getTiles() {
        return this.area;
    }


    /**
     * Returns the size (amount of tiles) of this area.
     *
     * @return amount of tiles
     */
    public int size() {
        return area.length * area[0].length;
    }

    public ATile[][] getCopy() {
        return new Area(Area.this.area.length, Area.this.area[0].length) {
            public void fill() {
                Area.this.fill();
            }}.getTiles();
    }

    /**
     * Returns a String representation of this area using {@link ATile#toChar()} for each tile.
     *
     * @return a string representation
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ATile[] row : area) {
            for (ATile x : row) s.append(x.toChar()).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}
