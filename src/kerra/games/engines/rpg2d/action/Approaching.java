package kerra.games.engines.rpg2d.action;

import kerra.games.engines.rpg2d.events.Action;
import kerra.games.engines.rpg2d.player.APlayer;
import org.jetbrains.annotations.NotNull;

public class Approaching {

    private final APlayer approacher;

    public Approaching(@NotNull APlayer approacher) {
        this.approacher = approacher;
    }

}
