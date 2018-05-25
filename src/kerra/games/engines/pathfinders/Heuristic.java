package kerra.games.engines.pathfinders;

import kerra.games.engines.rpg2d.tiles.ATile;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;

class Heuristic implements AStarAdmissibleHeuristic<ATile> {

    /**
     * An admissible "heuristic estimate" of the distance from $x$,
     * the sourceVertex, to the goal (usually denoted $h(x)$).
     * This is the good guess function which must never overestimate the distance.
     *
     * @param a the source vertex
     * @param b the target vertex
     * @return the manhattan metric between both vertexes position
     */
    @Override
    public double getCostEstimate(ATile a, ATile b) {
        int x = a.getPosition()[0] - b.getPosition()[0];
        int y = a.getPosition()[1] - b.getPosition()[1];
        return Math.abs(x) + Math.abs(y);
    }
}
