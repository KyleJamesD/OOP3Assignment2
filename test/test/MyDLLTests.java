/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import implementations.MyDLL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utilities.ListADT;

/**
 *
 * @author Will
 */
public class MyDLLTests {
    
    private ListADT<Integer> list;

    @Before
    public void setUp() {
        list = new MyDLL<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        assertEquals(1, list.size());
        assertEquals((Integer) 1, list.get(0));
    }

    @Test
    public void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(1, 3);
        assertEquals(3, list.size());
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 3, list.get(1));
        assertEquals((Integer) 2, list.get(2));
    }

    @Test
    public void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        Integer removedElement = list.remove(0);
        assertEquals((Integer) 1, removedElement);
        assertEquals(1, list.size());
        assertEquals((Integer) 2, list.get(0));
    }

    @Test
    public void testRemoveByElement() {
        list.add(1);
        list.add(2);
        Integer removedElement = list.remove(Integer.valueOf(1));
        assertEquals((Integer) 1, removedElement);
        assertEquals(1, list.size());
        assertEquals((Integer) 2, list.get(0));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testContains() {
        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 2, list.get(1));
    }

    @Test
    public void testSet() {
        list.add(1);
        list.add(2);
        list.set(1, 3);
        assertEquals((Integer) 3, list.get(1));
    }

    @Test
    public void testToArray() {
        list.add(1);
        list.add(2);
        Object[] array = list.toArray();
        assertEquals(2, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
    }

    @Test
    public void testToArrayGeneric() {
        list.add(1);
        list.add(2);
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        assertEquals(2, array.length);
        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
    }
}
