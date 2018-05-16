package kerra.games.engines.rpg2d.events;

import org.jetbrains.annotations.NotNull;

public class Dialogue {

    private final Message[] persons;
    private final int[] personToSpeak;
    private int counter;

    /**
     * Creates a new dialogue stack with the specified messages.
     * The {@code personToSpeak} array is needed to determine which {@link Message} to get the next message from.
     *
     * @param persons       the message stack. Must not be {@code null}.
     * @param personToSpeak the relative indexes. Must not be {@code null}.
     *
     */
    public Dialogue(@NotNull Message[] persons, int[] personToSpeak) {
        this.persons = persons;
        this.personToSpeak = personToSpeak;
        this.counter = 0;
    }

    /**
     * Returns the next message in the dialogue stack using a counter modulo {@link #size()}.
     *
     * @return the next message in the dialogue stack.
     * @throws ArrayIndexOutOfBoundsException   if the specified index in {@link #personToSpeak}
     *                                          is not in range {@code [0, messages]}.
     */
    public String nextMessage() {
        String message = persons[personToSpeak[counter % size()]].nextMessage();
        counter++;
        return message;
    }

    /**
     * Returns the size of this dialogue stack.
     *
     * @return the size of this dialogue stack
     */
    public int size() {
        return this.persons.length;
    }

    /**
     * Prints the next message in the dialogue stack.
     */
    public void print() {
        System.out.println(nextMessage());
    }
}
