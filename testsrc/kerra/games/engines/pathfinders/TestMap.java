package kerra.games.engines.pathfinders;

import kerra.games.engines.rpg2d.maps.Map;
import kerra.games.engines.rpg2d.resources.tiles.water.Water;
import org.jetbrains.annotations.NotNull;

class TestMap extends Map {

    TestMap(int xSize, int ySize) {
        super(xSize, ySize);
    }

    @Override
    public void fill() {
        fillGround();

        for (int y=2; y<area.length-2; y++) {
            for (int x=2; x<area[y].length-2; x++)
                area[y][x] = new Water(x, y);
        }
    }

    /**
     * Returns the getName of this maps.
     *
     * @return getName of the maps
     */
    @NotNull
    @Override
    public String getName() {
        return "Test Map";
    }
}
