package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utilities.MyDLL;

import static org.junit.Assert.*;

public class MyDLLTest {

    MyDLL<Integer> list;
    @Before
    public void setUp() throws Exception {
        list = new MyDLL<>();
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
        MyDLL<Integer> list2 = new MyDLL<>();
        list2.add(2);
        list.addAll(list2);
        assertEquals(2, list.size());
    }

    @Test
    public void get() {
        assertEquals(1, list.get(0).intValue());
    }

    @Test
    public void remove() {
        assertEquals(1, list.remove(0).intValue());
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove() {
        assertEquals(1,list.remove(Integer.valueOf(1)).intValue());
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
        Object[] arr = list.toArray();
        assertEquals(1, arr.length);
        assertEquals(1, arr[0]);
    }

    @Test
    public void testToArray() {
        Integer[] arr = new Integer[1];
        arr = list.toArray(arr);
        assertEquals(1, arr.length);
        assertEquals(1, arr[0].intValue());
    }

    @Test
    public void iterator() {
        assertNotNull(list.iterator());
        assertTrue(list.iterator().hasNext());
        assertEquals(1, list.iterator().next().intValue());
    }
}