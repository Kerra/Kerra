package kerra.util;

import static org.junit.jupiter.api.Assertions.*;

class TriggerListTest {

    private TriggerList<Integer, Character> list;
    private Integer[] elements = {1, 2, 3, 4, 5};
    private Character[] triggers = {'a', 'b', 'c', 'd', 'e'};



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.list = new TriggerList<>(elements.length);
    }

    @org.junit.jupiter.api.Test
    void add() {
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i]);
            assertEquals(elements[i], list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void add1() {
        for (int i=0; i<elements.length; i++) {
            list.add(elements[i], triggers[i]);
            assertEquals(elements[i], list.get(i));
            assertEquals(triggers[i], list.getTrigger(i));
        }
    }

    @org.junit.jupiter.api.Test
    void add2() {
        for (int i=0; i<elements.length; i++) {
            list.add(i, elements[i]);
            assertEquals(elements[i], list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void add3() {
        for (int i=0; i<elements.length; i++) {
            list.add(i, elements[i], triggers[i]);
            assertEquals(elements[i], list.get(i));
            assertEquals(triggers[i], list.getTrigger(i));
        }
    }

    @org.junit.jupiter.api.Test
    void set() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) {
            list.set(i, elements[0]);
            assertEquals(elements[0], list.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void set1() {
        for (int i=0; i<elements.length; i++) list.add(elements[i], triggers[i]);
        for (int i=0; i<elements.length; i++) {
            list.set(i, elements[0], triggers[0]);
            assertEquals(elements[0], list.get(i));
            assertEquals(triggers[0], list.getTrigger(i));
        }
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) assertEquals(elements[i], list.toArray()[i]);
    }

    @org.junit.jupiter.api.Test
    void toArray1() {
        for (int i=0; i<elements.length; i++) list.add(elements[i], triggers[i]);
        for (int i=0; i<elements.length; i++) assertEquals(elements[i], list.toArray()[i]);
    }

    @org.junit.jupiter.api.Test
    void size() {
        for (Integer i : elements) list.add(i);
        assertEquals(elements.length, list.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        for (Integer i : elements) list.add(i);
        assertFalse(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        for (Integer i : elements) list.add(i);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void get() {
        add();
    }

    @org.junit.jupiter.api.Test
    void hasTrigger() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) assertFalse(list.hasTrigger(i));
        list.clear();
        for (int i=0; i<elements.length; i++) list.add(elements[i], triggers[i]);
        for (int i=0; i<elements.length; i++) assertTrue(list.hasTrigger(i));
    }

    @org.junit.jupiter.api.Test
    void getTrigger() {
        for (Integer i : elements) list.add(i);
        for (int i=0; i<elements.length; i++) assertNull(list.getTrigger(i));
        list.clear();
        for (int i=0; i<elements.length; i++) list.add(elements[i], triggers[i]);
        for (int i=0; i<elements.length; i++) assertEquals(triggers[i], list.getTrigger(i));
    }

    @org.junit.jupiter.api.Test
    void trimToSize() {
        for (Integer i : elements) list.add(i);
        list.trimToSize();
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        int c = 0;
        for (Integer i : list) {
            assertEquals(elements[c], i);
            ++c;
        }
    }
}