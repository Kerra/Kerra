package kerra.games.engines.rpg2d;

import kerra.games.engines.rpg2d.condition.Condition;
import kerra.games.engines.rpg2d.player.APlayer;
import org.jetbrains.annotations.NotNull;

public abstract class Driver {

    private APlayer player;

    public abstract void setUp();

    public void run() {
        setUp();
        print();

        Condition c;
        int i = 0;
        while (i < 50) {
            player.move();
            c = player.getTile().getCondition();
            if (c != null && c.ask()) c.getAction().run();
            print();
            i++;
        }
    }

    public void setPlayer(@NotNull APlayer player) {
        this.player = player;
    }

    private void print() {
        System.out.println(player.getArea().toString());
    }
}
