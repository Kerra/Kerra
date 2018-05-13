package kerra.games.engines.rpg2d.Area;

import org.junit.jupiter.api.Test;

class AreaTest {

    private Area area = new Area(10, 10) {public void fill() {}};

    @Test
    void fillGround() {
        area.fillGround();
        print();
    }

    @Test
    void fillMountain() {
        area.fillMountain();
        print();
    }

    @Test
    void fillRock() {
        area.fillRock();
        print();
    }

    @Test
    void fillWater() {
        area.fillWater();
        print();
    }

    private void print() {
        System.out.println(area.toString());
    }
}