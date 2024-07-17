/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementations;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author kyled
 */
public class MyDLLTest {
    
    public MyDLLTest() {
    }
    
    private MyDLL MyDLLTest;
    
    @Before
    public void setUp() {
        MyDLLTest = new MyDLL<>();
        MyDLLTest.add(0, new Node<>(1));
        MyDLLTest.add(1, new Node<>(2.0));
        MyDLLTest.add(2, new Node<>("Three"));
        MyDLLTest.add(3, new Node<>("4"));
        MyDLLTest.add(4, new Node<>(5));
        MyDLLTest.add(5, new Node<>(6));
 
    }

    /**
     * Test of size method, of class MyDLL.
     */
    @Test
    public void testSize() {
        int expResult = 6;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class MyDLL.
     */
    @Test
    public void testClear() {

        MyDLLTest.clear();
        int expResult = 0;
        
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAdd_int_GenericType() {
        
        MyDLLTest.add(5, new Node<>(6));
        int expResult = 7;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
        
        //TO DO : add check with get to see if nodes have shifted
        
    }

    /**
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAdd_GenericType() {
        
        
        MyDLLTest.add(new Node<>(7.0));
        int expResult = 7;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
        
        
        
    }

    /**
     * Test of addAll method, of class MyDLL.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        ListADT toAdd = null;
        MyDLL instance = new MyDLL();
        boolean expResult = false;
        boolean result = instance.addAll(toAdd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class MyDLL.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyDLL instance = new MyDLL();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        MyDLL instance = new MyDLL();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemove_GenericType() {
        System.out.println("remove");
        Object toRemove = null;
        MyDLL instance = new MyDLL();
        Object expResult = null;
        Object result = instance.remove(toRemove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class MyDLL.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object toChange = null;
        MyDLL instance = new MyDLL();
        Object expResult = null;
        Object result = instance.set(index, toChange);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class MyDLL.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyDLL instance = new MyDLL();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class MyDLL.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object toFind = null;
        MyDLL instance = new MyDLL();
        boolean expResult = false;
        boolean result = instance.contains(toFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Object[] toHold = null;
        MyDLL instance = new MyDLL();
        Object[] expResult = null;
        Object[] result = instance.toArray(toHold);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        MyDLL instance = new MyDLL();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class MyDLL.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyDLL instance = new MyDLL();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasNext method, of class MyDLL.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        MyDLL instance = new MyDLL();
        boolean expResult = false;
        boolean result = instance.hasNext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class MyDLL.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        MyDLL instance = new MyDLL();
        Node expResult = null;
        Node result = instance.next();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
