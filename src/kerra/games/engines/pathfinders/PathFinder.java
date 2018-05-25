package kerra.games.engines.pathfinders;

import kerra.games.engines.rpg2d.players.APlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public final class PathFinder {

    private AStarShortestPath<ATile, DefaultEdge> shortestPath;
    private SimpleGraph<ATile, DefaultEdge> graph;
    private ATile[][] map;

    /**
     * Creates a new pathfinder for the specified maps.
     *
     * @param map   the maps to use for path finding
     */
    public PathFinder(@NotNull ATile[][] map) {
        this.map = map;
        this.graph = new SimpleGraph<>(DefaultEdge.class);
        this.shortestPath = new AStarShortestPath<>(graph, new Heuristic());
    }

    /**
     * Initializes the graph with vertexes and edges.
     * If the specified players cannot enter a specific {@link ATile}, the vertex will be removed.
     *
     * @param player    the players to traverse each tile
     */
    private void init(@NotNull APlayer player) {
        // add vertexes
        for (ATile[] a : map)
            for (ATile b : a)
               graph.addVertex(b);
        // add horizontal edges
        for (ATile[] a : map)
            for (int x = 1; x < a.length; x++)
                graph.addEdge(a[x-1], a[x]);
        // add vertical edges
        for (int y = 1; y < map.length; y++)
            for (int x = 0; x < map[y].length; x++)
                graph.addEdge(map[y-1][x], map[y][x]);
        // remove vertexes the players cannot enter
        for (ATile[] a : map)
            for (ATile b : a)
                if (!b.canEnter(player)) graph.removeVertex(b);
    }

    /**
     * Calculates and returns the shortest path from the specified {@code start} to the specified {@code target}.
     * This method uses the {@code A*} algorithm and searches for {@link ATile}s the specified players can enter.
     * As all {@code ATiles}, the players cannot enter will be removed from the computation,
     * the start and target <b>must be empty of any players</b>!
     *
     * @param player    the players searching the path
     * @param start     the start tile
     * @param target    the target tile
     * @return  the path as an array
     */
    @NotNull
    public ATile[] findPath(@NotNull APlayer player, @NotNull ATile start, @NotNull ATile target) {
        init(player);GraphPath path = shortestPath.getPath(start, target);
        return (ATile[]) path.getVertexList().toArray(new ATile[0]);
    }
}
