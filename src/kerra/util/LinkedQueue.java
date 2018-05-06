package kerra.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class contains various methods to realize a linked queue. <br>
 * To perform like expected, the user is needed to first add all the elements before querying next elements.
 * Otherwise unexpected queue order may occur. <br>
 *
 * Except when noted, all input parameters should not be {@code null},
 * otherwise an {@code IllegalArgumentException} may be thrown.<br>
 * This class is a member of the kerra Framework at {@code https://github.com/kerra}.
 *
 * @author Julius Oeftiger (https://github.com/kerra)
 *
 * @param <E>   the type of elements in this list
 */
public class LinkedQueue<E> implements Iterable<E> {

    private int index;
    private E next;
    private ArrayList<E> queue;



    /**
     * Constructs an empty linked queue with an initial capacity of ten.
     */
    public LinkedQueue() {
        this(0);
    }



    /**
     * Constructs an empty linked queue with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the queue
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    public LinkedQueue(int initialCapacity) {
        this.queue = new ArrayList<>(initialCapacity);
        this.index = 0;
    }



    /**
     * Appends the specified element to the end of this queue.
     *
     * @param element   element to be appended to this queue
     * @throws ClassCastException   if the class of the specified element prevents
     *                              it from being added to this queue
     */
    public void add(E element) {
        this.queue.add(element);
        if (queue.size() == 1) this.next = queue.get(0);
    }



    /**
     * Retrieves, but does not rotate, the head of this queue, or returns {@code null}
     * if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @org.jetbrains.annotations.Contract(pure = true)
    @org.jetbrains.annotations.Nullable
    public E peek() {
        return isEmpty() ? null : this.next;
    }



    /**
     * Retrieves the head of this queue, or returns {@code null} if this queue is empty.
     * This queue will be rotated once.
     *
     * @return
     */
    @org.jetbrains.annotations.Contract(pure = true)
    @org.jetbrains.annotations.Nullable
    public E next() {
        if (isEmpty()) return null;
        E next = this.next;
        index = (index + 1) % queue.size();
        this.next = queue.get(index);
        return next;
    }



    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator
     */
    @org.jetbrains.annotations.NotNull
    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }



    /**
     * Returns the number of elements in this list.
     *
     * @return  the number of elements in this list
     */
    public int size() {
        return this.queue.size();
    }


    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
