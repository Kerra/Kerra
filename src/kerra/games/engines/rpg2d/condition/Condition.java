package kerra.games.engines.rpg2d.condition;

import kerra.games.engines.rpg2d.action.Action;
import org.jetbrains.annotations.NotNull;

public abstract class Condition {

    protected Action action;

    /**
     * This implementation serves the purpose of the engine knowing when this Condition applies.
     * In this case, the engine will immediately call {@link #getAction()} to perform {@code getAction().run()}.
     * Any case of 'one-time' or 'self-resetting' events must be implemented by the user.
     *
     * @return {@code true} if condition is met.<br>
     *         {@code false} otherwise.
     */
    public abstract boolean ask();


    /**
     * Returns the corresponding {@code Action} for this condition.
     * Must not be {@code null}!
     *
     * @return the action corresponding to this condition
     */
    @NotNull
    public Action getAction() {
        return this.action;
    }
}
