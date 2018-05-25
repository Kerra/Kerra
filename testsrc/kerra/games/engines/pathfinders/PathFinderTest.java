package kerra.games.engines.pathfinders;

import kerra.games.engines.rpg2d.maps.Map;
import kerra.games.engines.rpg2d.players.ScriptPlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PathFinderTest {

    private Map map, map2;
    private String script = "1234";
    private ScriptPlayer player;
    private PathFinder pathFinder;
    private ATile start, start2, target, target2;

    @BeforeEach
    void setUp() {
        map2 = new TestMap(10, 10);
        map = new Map(10, 10) {
            public void fill() { fillGround(); }
            public @NotNull String getName() { return "maps"; }
        };
        player = ScriptPlayer.getInstance(script);
        start = map.getTile(0, 0);
        target = map.getTile(9, 9);
        start2 = map2.getTile(0, 0);
        target2 = map2.getTile(9, 9);
    }

    @Test
    void findPath1() {
        pathFinder = new PathFinder(map.getTiles());
        ATile[] path = pathFinder.findPath(player, start, target);
        for (ATile tile : path) System.out.println(tile.toString());
    }

    @Test
    void findPath2() {
        pathFinder = new PathFinder(map2.getTiles());
        ATile[] path = pathFinder.findPath(player, start2, target2);
        for (ATile tile : path) System.out.println(tile.toString());
    }
}