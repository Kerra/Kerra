package kerra.games.engines.rpg2d.events;

import org.jetbrains.annotations.NotNull;

public class Message {

    private String[] messages;
    private int counter;

    public Message(@NotNull String[] messages) {
        this.messages = messages;
        this.counter = 0;
    }

    public String nextMessage() {
        String message = messages[counter % size()];
        counter++;
        return message;
    }

    public final String nextMessage(int index) {
        return messages[index];
    }


    @NotNull
    public final String[] getMessages() {
        return this.messages;
    }

    public final int size() {
        return this.messages.length;
    }

    public final void print() {
        System.out.println(nextMessage());
    }
}
