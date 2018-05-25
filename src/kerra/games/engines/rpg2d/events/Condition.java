package kerra.games.engines.rpg2d.events;

import kerra.games.engines.rpg2d.tiles.ATile;

/**
 * This class features a primitive plugin for the engine to check for conditions.
 * An implementation of this abstract class may be given to {@link ATile},
 * which gets automatically checked by the engine and run, whenever the implementation returns {@code isMet() -> true}.
 * No deeper logic for 'one-time' or 'self-resetting' events is given.
 */
public abstract class Condition {

    /**
     * This method gets called by the engine to check for possible events.
     * Whenever {@code isMet()} returns {@code true}, {@link #run()} will be automatically run.
     * Any case of 'one-time' or 'self-resetting' events must be implemented by the user.
     *
     * @return {@code true} if condition is met.<br>
     *         {@code false} otherwise.
     */
    public abstract boolean isMet();

    /**
     * This method gets called automaticall by the engine whenever {@link #isMet()} returned {@code true}.
     * Any case of 'one-time' or 'self-resetting' events must be implemented by the user.
     */
    public abstract void run();
}
