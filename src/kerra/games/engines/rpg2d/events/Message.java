package kerra.games.engines.rpg2d.events;

import org.jetbrains.annotations.NotNull;

public class Message {

    private String[] messages;
    private int counter;

    public Message(@NotNull String[] messages) {
        this.messages = messages;
        this.counter = 0;
    }

    /**
     * Returns the next stored message (will loop through them).
     *
     * @return the next message on the stack
     */
    @NotNull
    public String nextMessage() {
        String message = messages[counter % size()];
        counter++;
        return message;
    }

    /**
     * Returns a message at a random index.
     *
     * @return a random message
     */
    @NotNull
    public final String randomMessage() {
        int index = (int) (Math.random() * messages.length);
        return messages[index];
    }

    /**
     * Returns the message at the specified index.
     *
     * @param index the index to retrieve
     * @return the message at the specified index
     * @throws ArrayIndexOutOfBoundsException if the specified index is out of bounds
     *                                        ({@code index < 0 || index >= size()})
     */
    @NotNull
    public final String getMessage(int index) {
        return messages[index];
    }

    /**
     * Returns all stored messages specified at creation.
     *
     * @return all stored messages
     */
    @NotNull
    public final String[] getMessages() {
        return this.messages;
    }

    /**
     * Returns the number of stored messages.
     *
     * @return the number of stored messages
     */
    public final int size() {
        return this.messages.length;
    }
}
