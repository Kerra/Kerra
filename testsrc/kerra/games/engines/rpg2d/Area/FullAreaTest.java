package kerra.games.engines.rpg2d.Area;

import kerra.games.engines.rpg2d.resources.tiles.ground.Grass;
import kerra.games.engines.rpg2d.resources.tiles.ground.Ground;
import kerra.games.engines.rpg2d.resources.tiles.ground.Rock;
import kerra.games.engines.rpg2d.resources.tiles.mountain.Mountain;
import kerra.games.engines.rpg2d.resources.tiles.mountain.MountainBot;
import kerra.games.engines.rpg2d.resources.tiles.mountain.MountainRight;
import kerra.games.engines.rpg2d.resources.tiles.water.CoastLeft;
import kerra.games.engines.rpg2d.resources.tiles.water.CoastTop;
import org.junit.jupiter.api.Test;

public class FullAreaTest {

    private Area area = new Area(13, 13) {
        @Override
        public void fill() {
            fillWater();

            // Mountain
            for (int y=0; y<4; y++) for (int x=0; x<4; x++) area[y][x] = new Mountain(x, y);
            for (int y=0; y<5; y++) area[y][4] = new MountainRight(4, y);
            for (int x=0; x<4; x++) area[4][x] = new MountainBot(x, 4);

            // Water
            for (int y=5; y<area.length; y++) area[y][5] = new CoastLeft(5, y);
            for (int x=5; x<area[0].length; x++) area[2][x] = new CoastTop(x, 2);

            // Ground
            for (int y=0; y<2; y++) for (int x=5; x<area[0].length; x++) area[y][x] = new Ground(x, y);
            for (int y=5; y<area.length-2; y++) for (int x=0; x<5; x++) area[y][x] = new Grass(x, y);
            for (int y=area.length-2; y<area.length; y++) for (int x=0; x<5; x++) area[y][x] = new Rock(x, y);
        }
    };

    @Test
    void print() {
        System.out.println(area.toString());
    }
}
