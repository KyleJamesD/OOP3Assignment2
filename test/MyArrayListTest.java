package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utilities.MyArrayList;

import static org.junit.Assert.*;

public class MyArrayListTest {

    MyArrayList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new MyArrayList<>();
        list.add(1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        assertEquals(1, list.size());
    }

    @Test
    public void clear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void add() {
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testAdd() {
        assertTrue(list.add(0, 2));
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void addAll() {
        list.addAll(list);
        assertEquals(2, list.size());


    }

    @Test
    public void get() {
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void remove() {
        assertEquals(1, list.remove(0).intValue());
    }

    @Test
    public void testRemove() {
        list.remove(Integer.valueOf(1));
        assertEquals(0, list.size());

    }

    @Test
    public void set() {
        list.set(0, 2);
        assertEquals(2, list.get(0).intValue());
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void contains() {
        assertTrue(list.contains(1));
    }

    @Test
    public void toArray() {
        Object[] array = list.toArray();
        assertEquals(1, array.length);
    }

    @Test
    public void testToArray() {
        Integer[] array = new Integer[1];
        array = list.toArray(array);
        assertEquals(1, array.length);
    }

    @Test
    public void iterator() {
        assertNotNull(list.iterator());
    }
}