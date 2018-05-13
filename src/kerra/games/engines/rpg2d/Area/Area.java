package kerra.games.engines.rpg2d.Area;

import kerra.games.engines.rpg2d.tiles.ATile;
import kerra.games.engines.rpg2d.tiles.ground.Ground;
import kerra.games.engines.rpg2d.tiles.ground.Rock;
import kerra.games.engines.rpg2d.tiles.mountain.Mountain;
import kerra.games.engines.rpg2d.tiles.water.Water;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

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
        for (ATile[] row : area) Arrays.fill(row, new Ground());
    }

    /**
     * Fills this area with {@link Mountain} tiles.
     */
    public void fillMountain() {
        for (ATile[] row : area) Arrays.fill(row, new Mountain());
    }

    /**
     * Fills this area with {@link Rock} tiles.
     */
    public void fillRock() {
        for (ATile[] row : area) Arrays.fill(row, new Rock());
    }

    /**
     * Fills this area with {@link Water} tiles.
     */
    public void fillWater() {
        for (ATile[] row : area) Arrays.fill(row, new Water());
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
