package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utilities.MyStack;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyStackTest {
    MyStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new MyStack<>();
        stack.push(1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void push() {
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void pop() {
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void peek() {
        assertEquals(1, stack.peek().intValue());
    }

    @Test
    public void clear() {
        stack.clear();
        assertEquals(0, stack.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] array = stack.toArray();
        assertEquals(1, array.length);
        assertEquals(1, ((Integer) array[0]).intValue());
    }

    @Test
    public void testToArray() {
        Integer[] array = stack.toArray(new Integer[1]);
        assertEquals(1, array.length);
        assertEquals(1, array[0].intValue());
    }

    @Test
    public void contains() {
        assertTrue(stack.contains(1));
    }

    @Test
    public void search() {
        assertEquals(1, stack.search(1));
        assertEquals(-1, stack.search(2));
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
    }

    @Test
    public void testEquals() {
        MyStack<Integer> stack2 = new MyStack<>();
        stack2.push(1);
        assertTrue(stack.equals(stack2));
    }

    @Test
    public void size() {
        assertEquals(1, stack.size());
    }
}