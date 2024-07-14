package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;
import utilities.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
        list.add(0, 1);
        list.add(1, 10);
        list.add(2, 20);
        list.add(3, 30);
        list.add(4, 40);
        list.add(5, 50);
        list.add(6, 60);
    }

    @Test
    void size() {
        assertEquals(7, list.size());
    }

    @Test
    void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void add() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(20, 22);
        });
        assertThrows(NullPointerException.class, () -> {
            list.add(1, null);
        });
        list.add(1, 10);
        assertEquals(10, list.get(1));
    }

    @Test
    void testAdd() {
        assertThrows(NullPointerException.class, () -> {
            list.add(1, null);
        });
        list.add(99);
    }

    @Test
    void addAll() {
        assertThrows(NullPointerException.class, () -> {
            list.addAll(null);
        });
        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(0, 70);
        list2.add(1, 80);
        list2.add(2, 90);
        list.addAll(list2);
        assertEquals(10, list.size());
    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(88);
        });
        assertEquals(1, list.get(0));
    }

    @Test
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(11);
        });
        list.remove(2);
        assertEquals(30, list.get(2));
    }

    @Test
    void testRemove() {
        assertThrows(NullPointerException.class, () -> {
            list.remove(null);
        });
        list.remove(0);
    }

    @Test
    void set() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(12, 10);
        });
        assertThrows(NullPointerException.class, () -> {
            list.set(1, null);
        });
        list.set(7, 70);
    }

    @Test
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        assertThrows(NullPointerException.class, () -> {
            list.contains(null);
        });
        assertTrue(list.contains(10));
    }

    @Test
    void toArray() {
        assertThrows(NullPointerException.class, () -> {
            list.toArray(null);
        });
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        assertArrayEquals(new Integer[]{1,10, 20, 30, 40, 50, 60}, array);
    }

    @Test
    void testToArray() {
        Object[] array = list.toArray();
        assertArrayEquals(new Object[]{1, 10, 20, 30, 40, 50, 60}, array);
    }

    @Test
    void iterator() {
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(10, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(30, iterator.next());
        assertEquals(40, iterator.next());
        assertEquals(50, iterator.next());
        assertEquals(60, iterator.next());
        assertFalse(iterator.hasNext());
    }
}