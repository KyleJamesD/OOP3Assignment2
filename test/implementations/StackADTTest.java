/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementations;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;
import utilities.Iterator;
import utilities.StackADT;
import static org.junit.Assert.*;
import utilities.ListADT;

/**
 *
 * @author kyled
 */
public class StackADTTest {
    
    public StackADTTest() {
        
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of push method, of class StackADT.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object toAdd = null;
        StackADT instance = new StackADTImpl();
        instance.push(toAdd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class StackADT.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        StackADT instance = new StackADTImpl();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class StackADT.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        StackADT instance = new StackADTImpl();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class StackADT.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        StackADT instance = new StackADTImpl();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class StackADT.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StackADT instance = new StackADTImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class StackADT.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        StackADT instance = new StackADTImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class StackADT.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Object[] holder = null;
        StackADT instance = new StackADTImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray(holder);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class StackADT.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object toFind = null;
        StackADT instance = new StackADTImpl();
        boolean expResult = false;
        boolean result = instance.contains(toFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class StackADT.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Object toFind = null;
        StackADT instance = new StackADTImpl();
        int expResult = 0;
        int result = instance.search(toFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class StackADT.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        StackADT instance = new StackADTImpl();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class StackADT.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        StackADT instance = new StackADTImpl();
        boolean expResult = false;
        boolean result = instance.equals(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class StackADT.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        StackADT instance = new StackADTImpl();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class StackADTImpl implements StackADT {

        public void push(E toAdd) throws NullPointerException {
        }

        public E pop() throws EmptyStackException {
            return null;
        }

        public E peek() throws EmptyStackException {
            return null;
        }

        public void clear() {
        }

        public boolean isEmpty() {
            return false;
        }

        public Object[] toArray() {
            return null;
        }

        public E[] toArray(E[] holder) throws NullPointerException {
            return null;
        }

        public boolean contains(E toFind) throws NullPointerException {
            return false;
        }

        public int search(E toFind) {
            return 0;
        }

        public Iterator<E> iterator() {
            return null;
        }

        public boolean equals(StackADT<E> that) {
            return false;
        }

        public int size() {
            return 0;
        }
    }
    
}
