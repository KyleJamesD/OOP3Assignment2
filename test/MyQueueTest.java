package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utilities.MyQueue;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyQueueTest {

    MyQueue<Integer> queue;
    @Before
    public void setUp() throws Exception {
        queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void enqueue() {
        queue.enqueue(4);
        assertEquals(4, queue.size());
    }

    @Test
    public void dequeue() {
        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.size());
    }

    @Test
    public void peek() {
        assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void dequeueAll() {
        queue.dequeueAll();
        assertEquals(0, queue.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(queue.isEmpty());
        queue.dequeueAll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void iterator() {
        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEquals() {
        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        assertTrue(queue.equals(queue2));
    }

    @Test
    public void toArray() {
        Object[] array = queue.toArray();
        assertEquals(3, array.length);
        assertEquals(1, ((Integer) array[0]).intValue());
    }

    @Test
    public void testToArray() {
        Integer[] array = new Integer[1];
        array = queue.toArray(array);
        assertEquals(3, array.length);
        assertEquals(1, array[0].intValue());
    }

    @Test
    public void isFull() {
        assertFalse(queue.isFull());
    }

    @Test
    public void size() {
        assertEquals(3, queue.size());
    }
}