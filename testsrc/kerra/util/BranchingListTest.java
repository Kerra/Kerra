package kerra.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BranchingListTest {

    private BranchingList<Integer> list;
    private Integer[] elements = {1, 2, 3, 4, 5};
    private BranchingList<Integer> branch;

    @BeforeEach
    void setUp() {
        this.list = new BranchingList<>(elements.length);
        this.branch = new BranchingList<>(elements.length);
        for (Integer i : elements) branch.add(i);
    }

    @Test
    void add() {
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i]);
            assertEquals(elements[i], list.get(i));
        }
    }

    @Test
    void add1() {
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i], branch);
            assertEquals(elements[i], list.get(i));
            assertEquals(branch, list.getBranch(i));
        }
    }

    @Test
    void add2() {
        for (int i=0; i<elements.length; i++) {
            list.add(i, elements[i]);
            assertEquals(elements[i], list.get(i));
        }
    }

    @Test
    void add3() {
        for (int i=0; i<elements.length; i++) {
            list.add(i, elements[i], branch);
            assertEquals(elements[i], list.get(i));
            assertEquals(branch, list.getBranch(i));
        }
    }

    @Test
    void addBranch() {
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i]);
            list.addBranch(branch);
            assertEquals(elements[i], list.get(i));
            assertEquals(branch, list.getBranch(i));
        }
    }

    @Test
    void addBranch1() {
        for (int i=0; i<elements.length; i++) {
            list.add(i, elements[i]);
            list.addBranch(i, branch);
            assertEquals(elements[i], list.get(i));
            assertEquals(branch, list.getBranch(i));
        }
    }

    @Test
    void set() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) {
            list.set(i, elements[0]);
            assertEquals(elements[0], list.get(i));
        }
    }

    @Test
    void set1() {
        for (Integer element : elements) list.add(element, branch);
        for (int i=0; i<elements.length; i++) {
            list.set(i, elements[0], branch);
            assertEquals(elements[0], list.get(i));
            assertEquals(branch, list.getBranch(i));
        }
    }

    @Test
    void get() {
        add();
    }

    @Test
    void getBranch() {
        for (Integer element : elements) list.add(element, branch);
        for (int i=0; i<elements.length; i++) assertEquals(branch, list.getBranch(i));
    }

    @Test
    void hasBranch() {
        for (Integer element : elements) list.add(element);
        for (int i=0; i<elements.length; i++) assertFalse(list.hasBranch(i));
        list.clear();
        for (Integer element : elements) list.add(element, branch);
        for (int i=0; i<elements.length; i++) assertTrue(list.hasBranch(i));
    }

    @Test
    void toArray() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) assertEquals(elements[i], list.toArray()[i]);
    }

    @Test
    void toArray1() {
        for (Integer element : elements) list.add(element, branch);
        for (int i=0; i<elements.length; i++) assertEquals(elements[i], list.toArray()[i]);
    }

    @Test
    void size() {
        for (Integer i : elements) list.add(i);
        assertEquals(elements.length, list.size());
    }

    @Test
    void trimToSize() {
        for (Integer i : elements) list.add(i);
        list.trimToSize();
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        for (Integer i : elements) list.add(i);
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        for (Integer i : elements) list.add(i);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void iterator() {
        int c = 0;
        for (Integer i : list) {
            assertEquals(elements[c], i);
            ++c;
        }
    }
}