/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementations;

import org.junit.Test;
import static org.junit.Assert.*;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author kyled
 */
public class MyArrayListTest {
    
    public MyArrayListTest() {
    }

    /**
     * Test of size method, of class ListADT.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int capacity = 10;
        Double data[] = new Double[10];
        data[0] = (double)6;
        
        
        
        
        
        ListADT instance = new MyArrayList(capacity,data);
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ListADT.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ListADT instance = new ListADTImpl();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ListADT.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("add");
        int index = 0;
        Object toAdd = null;
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.add(index, toAdd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ListADT.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object toAdd = null;
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.add(toAdd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class ListADT.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");
        ListADT toAdd = null;
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.addAll(toAdd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class ListADT.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ListADT.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ListADT.
     */
    @Test
    public void testRemove_GenericType() {
        System.out.println("remove");
        Object toRemove = null;
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.remove(toRemove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class ListADT.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object toChange = null;
        ListADT instance = new ListADTImpl();
        Object expResult = null;
        Object result = instance.set(index, toChange);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class ListADT.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class ListADT.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object toFind = null;
        ListADT instance = new ListADTImpl();
        boolean expResult = false;
        boolean result = instance.contains(toFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class ListADT.
     */
    @Test
    public void testToArray_GenericType() {
        System.out.println("toArray");
        Object[] toHold = null;
        ListADT instance = new ListADTImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray(toHold);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class ListADT.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        ListADT instance = new ListADTImpl();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class ListADT.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        ListADT instance = new ListADTImpl();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
