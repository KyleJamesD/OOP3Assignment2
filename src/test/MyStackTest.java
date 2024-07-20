package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

import utilities.Iterator;
import utilities.MyStack;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    MyStack<Integer> myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack<>();
        myStack.push(1);
    }

    @Test
    void push() {
        assertThrows(NullPointerException.class, () -> myStack.push(null));
        myStack.push(2);
        assertEquals(2, myStack.size());
    }

    @Test
    void pop() {
        MyStack<Integer> myEmptyStack = new MyStack<>();
        assertThrows(EmptyStackException.class, () -> myEmptyStack.pop());
        assertEquals(1, myStack.pop());
    }

    @Test
    void peek() {
        assertEquals(1, myStack.peek());
    }

    @Test
    void clear() {
        myStack.clear();
        assertEquals(0, myStack.size());
    }

    @Test
    void isEmpty() {
        assertFalse(myStack.isEmpty());
    }

    @Test
    void toArray() {
        myStack.push(10);
        myStack.push(100);
        Integer[] array = new Integer[myStack.size()];
        array = myStack.toArray(array);
        assertArrayEquals(new Integer[]{100, 10, 1}, array);
    }

    @Test
    void testToArray() {
        myStack.push(10);
        myStack.push(100);
        Object[] array = myStack.toArray();
        assertArrayEquals(new Object[]{100, 10, 1}, array);
    }

    @Test
    void contains() {
        assertThrows(NullPointerException.class, () -> {
            myStack.contains(null);
        });
        assertTrue(myStack.contains(1));
    }

    @Test
    void search() {
        myStack.push(10);
        myStack.push(100);
        assertEquals(3, myStack.search(100));
    }

    @Test
    void iterator() {
        myStack.push(10);
        myStack.push(100);
        Iterator<Integer> iterator = myStack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(100, iterator.next());
        assertEquals(10, iterator.next());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEquals() {
        myStack.push(10);
        myStack.push(100);
        MyStack<Integer> myStack2 = new MyStack<>();
        myStack2.push(1);
        myStack2.push(10);
        assertFalse(myStack2.equals(myStack));
        myStack2.push(100);
        assertTrue(myStack2.equals(myStack));
    }

    @Test
    void size() {
        assertEquals(1, myStack.size());
        myStack.push(10);
        assertEquals(2, myStack.size());
    }
}