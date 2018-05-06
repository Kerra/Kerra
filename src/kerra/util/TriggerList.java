package kerra.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;


/**
 * This class contains various methods to realize a list with possibility to add a trigger / condition. <br>
 * This class tries to mimic the same syntax of {@link ArrayList}, but small deviations are possible. <br>
 * This class is a member of the <b>kerra Framework</b> at {@code https://github.com/kerra}.
 *
 * @author Julius Oeftiger (https://github.com/kerra)
 *
 * @param <E>   the type of elements in this list
 * @param <F>   the type of triggers in this list
 */
public class TriggerList<E, F> implements Iterable<E>  {

    private ArrayList<Item> items;



    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public TriggerList() {
        this(10);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public TriggerList(int initialCapacity) {
        this.items = new ArrayList<Item>(initialCapacity);
    }



    /**
     * Appends the specified element to the end of this list.
     * A trigger of type {@code null} will be used.
     *
     * @param element   element to be appended to this list
     * @throws ClassCastException   if the class of the specified element prevents
     *                              it from being added to this list
     */
    public void add(E element) {
        this.add(element, null);
    }



    /**
     * Appends the specified element to the end of this list.
     *
     * @param element   element to be appended to this list
     * @param trigger   trigger to be stored with the element
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    public void add(E element, F trigger) {
        Item item = new Item(element, trigger);
        items.add(item);
    }



    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * A trigger of type {@code null} will be used.
     *
     * @param index     index at which the specified element is to be inserted
     * @param element   element to be inserted
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    public void add(int index, E element) {
        this.add(index, element, null);
    }



    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index     index at which the specified element is to be inserted
     * @param element   element to be inserted
     * @param trigger   trigger to be stored with the element
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()}
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     *
     */
    public void add(int index, E element, F trigger) {
        Item item = new Item(element, trigger);
        items.add(index, item);
    }



    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index     index of the element to replace
     * @param element   element to be stored at the specified position
     * @return  the element previously at the specified position
     * @throws  IndexOutOfBoundsException   if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public E set(int index, E element) {
        return this.set(index, element, null);
    }



    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index     index of the element to replace
     * @param element   element to be stored at the specified position
     * @param trigger   trigger to be stored with the element
     * @return  the element previously at the specified position
     * @throws  IndexOutOfBoundsException   if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public E set(int index, E element, F trigger) {
        Item item = new Item(element, trigger);
        return items.set(index, item).item;
    }



    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * (from first to last element).<br>
     * The returned array will be "safe" in that no references to it are maintained by
     * this list. (In other words, this method must allocate a new array). The caller
     * is thus free to modify the returned array. <br>
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * @return  an array containing all of the elements in this list in proper sequence (no triggers included)
     */
    public Object[] toArray() {
        return IntStream.range(0, size()).mapToObj(i -> items.get(i).item).toArray();
    }



    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * (from first to last element); the runtime type of the returned array is that of
     * the specified array. If the list fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the specified array
     * and the size of this list.<br>
     * If the list fits in the specified array with room to spare (i.e., the array has
     * more elements than the list), the element in the array immediately following the
     * end of the collection is set to {@code null}. (This is useful in determining the length of
     * the list <i>only</i> if the caller knows that the list does not contain any null elements.)
     *
     * @param a     the array into which the elements of the list are to be stored, if it is big enough;
     *              otherwise, a new array of the same runtime type is allocated for this purpose.
     * @param <T>   the component type of the array to contain the collection
     * @return      an array containing the elements of the list (no triggers included)
     * @throws ArrayStoreException  if the runtime type of the specified array is not a supertype
     *                              of the runtime type of every element in this list
     * @throws NullPointerException if the specified array is null
     */
    @org.jetbrains.annotations.NotNull
    @SuppressWarnings({"unchecked", "SuspiciousToArrayCall"})
    public <T> T[] toArray(T[] a) {
        ArrayList<E> ar = new ArrayList<>(size());
        for (int i=0; i<size(); i++)
            ar.add(items.get(i).item);
        return ar.toArray(a);
    }



    /**
     * Returns the number of elements in this list.
     *
     * @return  the number of elements in this list
     */
    public int size() {
        return items.size();
    }



    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return  {@code true} if this list contains no elements
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public boolean isEmpty() {
        return items.isEmpty();
    }



    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        items.clear();
    }



    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return      the element at the specified position in this list
     * @throws IndexOutOfBoundsException    if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public E get(int index) {
        return items.get(index).item;
    }



    /**
     * Returns {@code true} if the element at the specified index in this list has a trigger.
     *
     * @param index index of the element
     * @return  {@code true} if the element has a trigger
     *          ({@code trigger != null})
     * @throws  IndexOutOfBoundsException   if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public boolean hasTrigger(int index) {
        return items.get(index).trigger != null;
    }



    /**
     * Returns the trigger of the element at the specified index.
     *
     * @param index index of the element
     * @return      trigger of the element
     * @throws IndexOutOfBoundsException   if the index is out of range
     *                                     ({@code index < 0 || index >= size()})
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public F getTrigger(int index) {
        return items.get(index).trigger;
    }



    /**
     * Trims the capacity of this {@code TriggerList} instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an {@code TriggerList} instance.
     */
    public void trimToSize() {
        items.trimToSize();
    }



    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator
     */
    @org.jetbrains.annotations.NotNull
    @Override
    public Iterator<E> iterator() {
        ArrayList<E> ar = new ArrayList<>(size());
        for (int i=0; i<size(); i++)
            ar.add(items.get(i).item);
        return ar.iterator();
    }



    private class Item {
        private E item;
        private F trigger;

        private Item(E item) {
            this(item, null);
        }

        private Item(E item, F trigger) {
            this.item = item;
            this.trigger = trigger;
        }
    }
}
