/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import implementations.MyStack;
import java.util.EmptyStackException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utilities.StackADT;

/**
 *
 * @author Will
 */
public class MyStackTests {

    private StackADT<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals((Integer) 1, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        assertEquals((Integer) 2, stack.pop());
        assertEquals(1, stack.size());
        assertEquals((Integer) 1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        assertEquals((Integer) 2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        stack.peek();
    }

    @Test
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testToArray() {
        stack.push(1);
        stack.push(2);
        Object[] array = stack.toArray();
        assertEquals(2, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
    }

    @Test
    public void testToArrayGeneric() {
        stack.push(1);
        stack.push(2);
        Integer[] array = new Integer[stack.size()];
        array = stack.toArray(array);
        assertEquals(2, array.length);
        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
    }

    @Test
    public void testContains() {
        stack.push(1);
        assertTrue(stack.contains(1));
        assertFalse(stack.contains(2));
    }

    @Test
    public void testSearch() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.search(3));
        assertEquals(2, stack.search(2));
        assertEquals(3, stack.search(1));
        assertEquals(-1, stack.search(4));
    }

    @Test
    public void testEquals() {
        StackADT<Integer> stack2 = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack2.push(1);
        stack2.push(2);
        assertTrue(stack.equals(stack2));
        stack2.pop();
        assertFalse(stack.equals(stack2));
    }
}
