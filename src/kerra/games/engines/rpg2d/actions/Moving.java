package kerra.games.engines.rpg2d.actions;

import kerra.games.engines.rpg2d.Engine;
import kerra.games.engines.rpg2d.players.APlayer;
import kerra.games.engines.rpg2d.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public final class Moving {

    public static void move(@NotNull APlayer player, @NotNull ATile[] path) {
        for (ATile tile : path) {
            player.moveTo(tile);
            Engine.getInstance().delay();
        }
    }
}
