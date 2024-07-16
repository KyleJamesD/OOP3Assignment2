/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementations;

import org.junit.Test;
import static org.junit.Assert.*;
import utilities.Iterator;
import utilities.ListADT;
import implementations.MyArrayList;

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
        data[0] = 6.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data);
        int expResult = 1; // Adjusted expected result based on the initialization
        int result = instance.size();
        assertEquals(expResult, result);
    }
    /**
     * Test of clear method, of class ListADT.
     */
    
    
    @Test
    public void testClear() {
        int capacity = 10;
        Double data[] = new Double[10];
        data[0] = 6.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data);
        int expResult = 1; // Adjusted expected result based on the initialization
        int result = instance.size();
        assertEquals(expResult, result);
        instance.clear();
        int expResult1 = 0; // Adjusted expected result based on the initialization
        int result1 = instance.size();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of add method, of class ListADT.
     */
    @Test
    public void testAdd_int_GenericType() {
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        boolean expResult = true;
        int index = 3;
        Double toAdd = 8.5;
        Double toCheck = 9.0;
        boolean result = instance.add(index, toAdd);
        assertEquals(expResult, result);
        assertEquals(instance.get(3), toAdd);
        assertEquals(instance.get(4), toCheck);
        assertEquals(instance.get(2), ((MyArrayList)instance).data[2]);
        assertEquals(instance.get(4), ((MyArrayList)instance).data[4]);
    }

    /**
     * Test of add method, of class ListADT.
     */
    @Test
    public void testAdd_GenericType() {
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        boolean expResult = true;
        Double toAdd = 8.5;
        boolean result = instance.add(toAdd);
        assertEquals(expResult, result);
        assertEquals(instance.get(4), toAdd);
        Double toAdd2 = 8.589;
        instance.add(toAdd2);
        assertEquals(instance.get(5), toAdd2);
    }

    /**
     * Test of addAll method, of class ListADT.
     */
    @Test
    public void testAddAll() {
        Double data1[] = new Double[10];
        data1[0] = 1.0;
        data1[1] = 2.0;
        data1[2] = 3.0;
        data1[3] = 4.0;
        MyArrayList instance = new MyArrayList<>(data1);
        
        Double data2[] = new Double[4];
        data2[0] = 6.0;
        data2[1] = 7.0;
        data2[2] = 8.0;
        data2[3] = 9.0;
        MyArrayList instance2 = new MyArrayList<>(data2);
        
        boolean expResult = true;
        
        //boolean result = instance.addAll(((MyArrayList)instance));
        boolean result2 = instance.addAll(instance2);
        //assertEquals(expResult, result);
        assertEquals(expResult, result2);
        assertEquals(instance.get(0), data1[0]);
        assertEquals(instance.get(1), data1[1]);
        assertEquals(instance.get(2), data1[2]);
        assertEquals(instance.get(3), data1[3]);
        assertEquals(instance.get(4), data2[0]);
        assertEquals(instance.get(5), data2[1]);
        assertEquals(instance.get(6), data2[2]);
        assertEquals(instance.get(7), data2[3]);
        
        int checksize = 8; 
        assertEquals(instance.size(), checksize);

    }

    /**
     * Test of get method, of class ListADT.
     */
    @Test
    public void testGet() {
        int capacity = 10;
        Double data[] = new Double[10];
        data[0] = 6.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data);
        double expResult = 6.0; 
        int index = 0;
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class ListADT.
     */
    @Test
    public void testRemove_int() {
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        
        int index = 0;
        
        
        Double toCheck = 6.0;
        
        Double expResult = instance.remove(index);
        assertEquals(expResult, toCheck);
        assertEquals(instance.get(0), data1[1]);
        assertEquals(instance.get(1), data1[2]);
        assertEquals(instance.get(2), data1[3]);
    }

    /**
     * Test of remove method, of class ListADT.
     */
    @Test
    public void testRemove_GenericType() {
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        data1[4] = 8.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        
        Double index = 8.0;
        
        
        Double toCheck = 8.0;
        
        Double expResult = instance.remove(index);
        assertEquals(expResult, toCheck);
        assertEquals(instance.get(0), data1[0]);
        assertEquals(instance.get(1), data1[1]);
        assertEquals(instance.get(2), null);
        assertEquals(instance.get(4), data1[4]);
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
