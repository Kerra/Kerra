package kerra.games.engines.rpg2d.resources.tiles.mountain;

import kerra.games.engines.rpg2d.players.IPlayer;
import kerra.games.engines.rpg2d.players.abilities.Climbing;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class MountainClimb extends ATile {

    public MountainClimb(int x, int y) {
        super(x, y);
    }

    /**
     * Returns {@code true} if the specified players can enter this tile.
     *
     * @param player the players wanting to enter
     * @return {@code true} if the players may enter.<br>
     * {@code false} otherwise
     */
    @Override
    public boolean canEnter(@NotNull IPlayer player) {
        return player.getAbilities().contains(Climbing.getInstance());
    }

    /**
     * Returns a {@code char} representation for a climbable mountain side.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return '¦';
    }
}
