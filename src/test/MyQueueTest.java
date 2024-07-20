package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.*;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue<>();
        queue.enqueue(new MyDLLNode<>(1));
        queue.enqueue(new MyDLLNode<>(2));
        queue.enqueue(new MyDLLNode<>(3));
        queue.enqueue(new MyDLLNode<>(4));
        queue.enqueue(new MyDLLNode<>(5));
        queue.enqueue(new MyDLLNode<>(6));
    }

    @Test
    void enqueue() {
        assertThrows(NullPointerException.class, () -> queue.enqueue(null));
        queue.enqueue(new MyDLLNode<>(7));
        assertEquals(7, queue.size());
    }

    @Test
    void dequeue() throws EmptyQueueException {
        queue.dequeue();
        assertEquals(5, queue.size());
    }

    @Test
    void peek() throws EmptyQueueException {
        assertEquals(new MyDLLNode<>(1).data, queue.peek().data);
    }

    @Test
    void dequeueAll() {
        queue.dequeueAll();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
    }

    @Test
    void iterator() {
        MyQueue<Integer> emptyquene = new MyQueue<>();
        Iterator<MyDLLNode<Integer>> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().data);   //index 0
        assertEquals(2, iterator.next().data);   //index 1
        assertEquals(3, iterator.next().data);   //index 2
        assertEquals(4, iterator.next().data);   //index 3
        assertEquals(5, iterator.next().data);   //index 4
        assertEquals(6, iterator.next().data);   //index 5
        assertFalse(iterator.hasNext());   //no index 6
    }

    @Test
    void testEquals() {
        MyQueue<Integer> queue2 = new MyQueue<>();
        queue2.enqueue(new MyDLLNode<>(1));
        MyQueue<Integer> queue3 = new MyQueue<>();
        queue3.enqueue(new MyDLLNode<>(1));
        assertTrue(queue2.equals(queue3));
        assertFalse(queue.equals(queue3));
    }

    @Test
    void toArray() {
        Object[] array = queue.toArray();
        assertEquals(6, array.length);
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    void testToArray() {
        assertThrows(NullPointerException.class, () -> {
            queue.toArray(null);
        });
        MyDLLNode<Integer>[] array = new MyDLLNode[6];
        MyDLLNode<Integer>[] result = queue.toArray(array);

        assertEquals(6, result.length);
        assertEquals(1, result[0].data);
        assertEquals(2, result[1].data);
        assertEquals(3, result[2].data);
        assertEquals(4, result[3].data);
        assertEquals(5, result[4].data);
        assertEquals(6, result[5].data);
    }

    @Test
    void isFull() {
        assertFalse(queue.isFull());
    }

    @Test
    void size() {
        assertEquals(6, queue.size());
    }
}