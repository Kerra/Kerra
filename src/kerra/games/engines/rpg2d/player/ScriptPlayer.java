package kerra.games.engines.rpg2d.player;

import kerra.games.engines.rpg2d.resources.tiles.ATile;
import org.jetbrains.annotations.NotNull;

public class ScriptPlayer extends APlayer {

    private static String script;
    private static int counter = 0;
    private static ScriptPlayer ourInstance = new ScriptPlayer();

    public static ScriptPlayer getInstance(@NotNull String script) {
        ScriptPlayer.script = script;
        return ourInstance;
    }

    private ScriptPlayer() { }


    /**
     * Orders the scripted Player to move according to before specified Script.
     */
    @Override
    public void move() {
        ATile target;
        int direction = (int) script.charAt(counter%script.length()) -48;//.parseInt(String.valueOf(script.charAt(counter)));
        switch (direction) {
            case 1: target = area.getTile(X, Y-1);
                break;
            case 2: target = area.getTile(X+1, Y);
                break;
            case 3: target = area.getTile(X, Y+1);
                break;
            case 4: target = area.getTile(X-1, Y);
                break;
            default: throw new AssertionError("Facing of " + this + "is out of bounds!");
        }
        if (target.canEnter(this)) moveTo(area, target.getPosition()[0], target.getPosition()[1]);
        else System.out.println("Illegal script entry: " + direction + ". Will skip counter: " + counter);
        counter++;
    }

    /**
     * Returns the char representation {@code 'S'} of this scripted player.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return 'S';
    }
}
