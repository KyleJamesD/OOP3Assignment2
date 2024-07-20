/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import exceptions.EmptyQueueException;
import implementations.MyQueue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import utilities.QueueADT;

/**
 *
 * @author Will
 */
public class MyQueueTests {

    private QueueADT<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueue() throws EmptyQueueException {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals((Integer) 1, queue.peek());
    }

    @Test
    public void testDequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals((Integer) 1, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals((Integer) 2, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueEmptyQueue() throws EmptyQueueException {
        queue.dequeue();
    }

    @Test
    public void testPeek() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals((Integer) 1, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test(expected = EmptyQueueException.class)
    public void testPeekEmptyQueue() throws EmptyQueueException {
        queue.peek();
    }

    @Test
    public void testDequeueAll() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeueAll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testToArray() {
        queue.enqueue(1);
        queue.enqueue(2);
        Object[] array = queue.toArray();
        assertEquals(2, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
    }

    @Test
    public void testToArrayGeneric() {
        queue.enqueue(1);
        queue.enqueue(2);
        Integer[] array = new Integer[queue.size()];
        array = queue.toArray(array);
        assertEquals(2, array.length);
        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
    }

    @Test
    public void testEquals() throws EmptyQueueException {
        QueueADT<Integer> queue2 = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue2.enqueue(1);
        queue2.enqueue(2);
        assertTrue(queue.equals(queue2));
        queue2.dequeue();
        assertFalse(queue.equals(queue2));
    }

    @Test
    public void testIsFull() {
        assertFalse(queue.isFull()); // This implementation does not have a fixed capacity
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }
}
