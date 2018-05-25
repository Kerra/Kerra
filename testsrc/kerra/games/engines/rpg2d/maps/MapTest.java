package kerra.games.engines.rpg2d.maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapTest {

    private Map map = new Map(10, 10) {
        public void fill() {}
    };

    @Test
    void fillGround() {
        map.fillGround();
        print();
    }

    @Test
    void fillMountain() {
        map.fillMountain();
        print();
    }

    @Test
    void fillRock() {
        map.fillRock();
        print();
    }

    @Test
    void fillWater() {
        map.fillWater();
        print();
    }

    @Test
    void name() {
        assertEquals(map.getClass().getName(), map.getName());
    }

    private void print() {
        System.out.println(map.toString());
    }
}