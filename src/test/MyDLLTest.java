package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Iterator;
import utilities.MyDLL;
import utilities.MyDLLNode;

import static org.junit.jupiter.api.Assertions.*;

class MyDLLTest1 {
    private MyDLL<Integer> myDll;

    @BeforeEach
    void setUp() {
        myDll = new MyDLL<>();
        myDll.add(0, new MyDLLNode<>(1));
        myDll.add(1, new MyDLLNode<>(2));
        myDll.add(2, new MyDLLNode<>(3));
        myDll.add(3, new MyDLLNode<>(4));
        myDll.add(4, new MyDLLNode<>(5));
        myDll.add(5, new MyDLLNode<>(6));
    }

    @Test
    void size() {
        assertEquals(6, myDll.size());
    }

    @Test
    void clear() {
        myDll.clear();
        assertEquals(0, myDll.size());
    }

    @Test
    void add() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myDll.add(26, new MyDLLNode<>(6));
        });
        assertThrows(NullPointerException.class, () -> {
            myDll.add(6, null);
        });
        myDll.add(6, new MyDLLNode<>(6));
        assertEquals(7, myDll.size());
        assertEquals(6, myDll.get(6).data);
    }

    @Test
    void testAdd() {
        assertThrows(NullPointerException.class, () -> {
            myDll.add(null);
        });
        myDll.add(new MyDLLNode<>(6));
        assertEquals(7, myDll.size());
        assertEquals(6, myDll.get(6).data);
    }

    @Test
    void addAll() {
        assertThrows(NullPointerException.class, () -> {
            myDll.addAll(null);
        });
        MyDLL<Integer> myDll2 = new MyDLL<>();
        myDll2.add(0, new MyDLLNode<>(7));
        myDll2.add(1, new MyDLLNode<>(8));
        myDll2.add(2, new MyDLLNode<>(9));
        myDll2.add(3, new MyDLLNode<>(10));
        myDll.addAll(myDll2);
        assertEquals(7, myDll.get(6).data);
        assertEquals(8, myDll.get(7).data);
        assertEquals(9, myDll.get(8).data);
        assertEquals(10, myDll.get(9).data);
        assertEquals(10, myDll.size());
    }

    @Test
    void get() {
        assertEquals(1, myDll.get(0).data);
    }

    @Test
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> {myDll.remove(20);});
        myDll.remove(1);
        assertEquals(5, myDll.size());
        assertEquals(3, myDll.get(1).data);
    }

    @Test
    void testRemove() {
        assertThrows(NullPointerException.class, () -> {
            myDll.remove(null);
        });
        myDll.remove(new MyDLLNode<>(3));
        assertEquals(5, myDll.size());
        assertEquals(4, myDll.get(2).data);
    }

    @Test
    void set() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myDll.set(26, new MyDLLNode<>(6));
        });
        assertThrows(NullPointerException.class, () -> {
            myDll.set(6, null);
        });
        myDll.set(5, new MyDLLNode<>(55555));
        assertEquals(55555, myDll.get(5).data);;
    }

    @Test
    void isEmpty() {
        assertFalse(myDll.isEmpty());
    }

    @Test
    void contains() {
        assertThrows(NullPointerException.class, () -> {
            myDll.contains(null);
        });
        assertTrue(myDll.contains(new MyDLLNode<>(6)));
    }

    @Test
    void toArray() {
        assertThrows(NullPointerException.class, () -> {
            myDll.toArray(null);
        });
        MyDLLNode<Integer>[] array = new MyDLLNode[6];
        MyDLLNode<Integer>[] result = myDll.toArray(array);

        assertEquals(6, result.length);
        assertEquals(1, result[0].data);
        assertEquals(2, result[1].data);
        assertEquals(3, result[2].data);
        assertEquals(4, result[3].data);
        assertEquals(5, result[4].data);
        assertEquals(6, result[5].data);
    }

    @Test
    void testToArray() {
        Object[] array = myDll.toArray();
        assertEquals(6, array.length);
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    void iterator() {
        MyDLL<Integer> emptyDll = new MyDLL<>();
        Iterator<MyDLLNode<Integer>> iterator = myDll.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().data);   //index 0
        assertEquals(2, iterator.next().data);   //index 1
        assertEquals(3, iterator.next().data);   //index 2
        assertEquals(4, iterator.next().data);   //index 3
        assertEquals(5, iterator.next().data);   //index 4
        assertEquals(6, iterator.next().data);   //index 5
        assertFalse(iterator.hasNext());   //no index 6
    }
}