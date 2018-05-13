package kerra.games.engines.rpg2d.Area;

import kerra.games.engines.rpg2d.tiles.ground.Grass;
import kerra.games.engines.rpg2d.tiles.ground.Ground;
import kerra.games.engines.rpg2d.tiles.mountain.Mountain;
import kerra.games.engines.rpg2d.tiles.mountain.MountainBot;
import kerra.games.engines.rpg2d.tiles.mountain.MountainRight;
import kerra.games.engines.rpg2d.tiles.water.CoastLeft;
import kerra.games.engines.rpg2d.tiles.water.CoastTop;
import org.junit.jupiter.api.Test;

public class FullAreaTest {

    private Area area = new Area(10, 10) {
        @Override
        public void fill() {
            fillWater();

            // Mountain
            for (int y=0; y<4; y++) for (int x=0; x<4; x++) area[y][x] = new Mountain();
            for (int y=0; y<5; y++) area[y][4] = new MountainRight();
            for (int x=0; x<4; x++) area[4][x] = new MountainBot();

            // Water
            for (int y=5; y<area.length; y++) area[y][5] = new CoastLeft();
            for (int x=5; x<area[0].length; x++) area[2][x] = new CoastTop();

            // Ground
            for (int y=0; y<2; y++) for (int x=5; x<area[0].length; x++) area[y][x] = new Ground();
            for (int y=5; y<area.length; y++) for (int x=0; x<5; x++) area[y][x] = new Grass();
        }
    };

    @Test
    void print() {
        System.out.println(area.toString());
    }


}
