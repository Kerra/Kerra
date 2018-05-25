package kerra.games.engines.rpg2d.players;

import kerra.games.engines.rpg2d.tiles.ATile;
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
            case 1: target = map.getTile(X, Y-1);
                break;
            case 2: target = map.getTile(X+1, Y);
                break;
            case 3: target = map.getTile(X, Y+1);
                break;
            case 4: target = map.getTile(X-1, Y);
                break;
            default: throw new AssertionError("Facing of " + this + "is out of bounds!");
        }
        if (target.canEnter(this)) moveTo(map, target.getPosition()[0], target.getPosition()[1]);
        else System.out.println("Illegal script entry: " + direction + ". Will skip counter: " + counter);
        counter++;
    }

    /**
     * Returns the char representation {@code 'S'} of this scripted players.
     *
     * @return a char representation
     */
    @Override
    public char toChar() {
        return 'S';
    }
}
