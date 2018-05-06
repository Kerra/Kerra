package kerra.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;


/**
 * This class contains various methods to realize a list with possibility to add another Branch ({@link BranchingList}). <br>
 * This class tries to mimic the same syntax of {@link ArrayList}, but small deviations are possible. <br>
 * This class is a member of the <b>kerra Framework</b> at {@code https://github.com/kerra}.
 *
 * @author Julius Oeftiger (https://github.com/kerra)
 *
 * @param <E>   the type of elements in this list.
 *              Any stored branch must be of same type
 */
public class BranchingList<E> implements Iterable<E> {

    private ArrayList<Branch> branchingList;



    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public BranchingList() {
        this(10);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is negative
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public BranchingList(int initialCapacity) {
        this.branchingList = new ArrayList<>(initialCapacity);
    }



    /**
     * Appends the specified element to the end of this list.
     * A branch of type {@code null} will be used.
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
     * @param branch    branch to be stored with the element
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    public void add(E element, BranchingList<E> branch) {
        Branch newBranch = new Branch(element, branch);
        branchingList.add(newBranch);
    }



    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * A branch of type {@code null} will be used.
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
     * @param branch    branch to be stored with the element
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()}
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     *
     */
    public void add(int index, E element, BranchingList<E> branch) {
        Branch newBranch = new Branch(element, branch);
        branchingList.add(index, newBranch);
    }



    /**
     * Appends the specified branch to the element at the end of this list.
     *
     * @param branch    branch to be appended to the element at the end of this list
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    public void addBranch(BranchingList<E> branch) {
        Branch oldBranch = branchingList.get(size()-1);
        oldBranch.branch = branch;
    }



    /**
     * Appends the specified branch to the element at the specified position in this list.
     *
     * @param index     index of the element at which the specified branch is to be appended
     * @param branch    branch to be appended to the element
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()}
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     *
     */
    public void addBranch(int index, BranchingList<E> branch) {
        Branch oldBranch = branchingList.get(index);
        oldBranch.branch = branch;
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
    public E set(int index, E element) {
        return this.set(index, element, null);
    }



    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index     index of the element to replace
     * @param element   element to be stored at the specified position
     * @param branch    branch to be stored with the element
     * @return  the element previously at the specified position
     * @throws  IndexOutOfBoundsException   if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     * @throws  ClassCastException  if the class of the element prevents it from being added to this list
     */
    public E set(int index, E element, BranchingList<E> branch) {
        Branch newBranch = new Branch(element, branch);
        return branchingList.set(index, newBranch).element;
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
        return branchingList.get(index).element;
    }



    /**
     * Returns the branch of the element at the specified position in this list.
     *
     * @param index index of the element whose branch to return
     * @return      the branch of the element at the specified position in this list
     * @throws IndexOutOfBoundsException    if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public BranchingList<E> getBranch(int index) {
        return branchingList.get(index).branch;
    }



    /**
     * Returns {@code true} if the element at the specified index in this list has a branch.
     *
     * @param index index of the element
     * @return  {@code true} if the element has a branch
     *          ({@code branch != null})
     * @throws  IndexOutOfBoundsException   if the index is out of range
     *                                      ({@code index < 0 || index >= size()})
     */
    @org.jetbrains.annotations.Contract(pure = true)
    public boolean hasBranch(int index) {
        return branchingList.get(index).branch != null;
    }



    /**
     * Returns an array containing all of the elements in this list in proper sequence
     * (from first to last element).<br>
     * The returned array will be "safe" in that no references to it are maintained by
     * this list. (In other words, this method must allocate a new array). The caller
     * is thus free to modify the returned array. <br>
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * @return  an array containing all of the elements in this list in proper sequence (no branches included)
     */
    public Object[] toArray() {
        return IntStream.range(0, size()).mapToObj(i -> branchingList.get(i).element).toArray();
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
     * @return      an array containing the elements of the list (no branches included)
     * @throws ArrayStoreException  if the runtime type of the specified array is not a supertype
     *                              of the runtime type of every element in this list
     * @throws NullPointerException if the specified array is null
     */
    @org.jetbrains.annotations.NotNull
    @SuppressWarnings({"unchecked", "SuspiciousToArrayCall"})
    public <T> T[] toArray(T[] a) {
        ArrayList<E> ar = new ArrayList<>(size());
        for (int i=0; i<size(); i++)
            ar.add(branchingList.get(i).element);
        return ar.toArray(a);
    }



    /**
     * Returns the number of elements in this list.
     *
     * @return  the number of elements in this list
     */
    public int size() {
        return this.branchingList.size();
    }



    /**
     * Trims the capacity of this {@code TriggerList} instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an {@code TriggerList} instance.
     */
    public void trimToSize() {
        this.branchingList.trimToSize();
    }



    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return  {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return this.branchingList.isEmpty();
    }



    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        this.branchingList.clear();
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
            ar.add(branchingList.get(i).element);
        return ar.iterator();
    }



    private class Branch {
        private E element;
        private BranchingList<E> branch;

        private Branch(E element) {
            this(element, null);
        }

        private Branch(E element, BranchingList<E> branch) {
            this.element = element;
            this.branch = branch;
        }
    }
}
