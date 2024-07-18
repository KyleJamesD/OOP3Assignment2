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
        MyDLLTest.add(0,1);
        MyDLLTest.add(1,2.0);
        MyDLLTest.add(2,"three");
        MyDLLTest.add(3,"4");
        MyDLLTest.add(4,5);
        MyDLLTest.add(5,6);
 
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
        
        MyDLLTest.add(5,6.5);
        int expResult = 7;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
        
        
        var result2 = MyDLLTest.get(5);
        var expResult2 = 6.5;
        assertEquals(expResult2,result2);
        
        MyDLLTest.add(5,22.5);
        var result3 = MyDLLTest.get(5);
        var expResult3 = 22.5;
        assertEquals(expResult3,result3);
        
        
        var result25 = MyDLLTest.get(6);
        var expResult25 = 6.5;
        assertEquals(expResult25,result25);
        
        
        int expResult4 = 8;
        int result4 = MyDLLTest.size();
        assertEquals(expResult4, result4);
        
    }

    /**
     * Test of add method, of class MyDLL.
     */
    @Test
    public void testAdd_GenericType() {
        
        
        MyDLLTest.add("this will be at the tail");
        String expResult = "this will be at the tail";
        int size = MyDLLTest.size();
        var result = MyDLLTest.get(size -1);
        assertEquals(expResult, result);
        System.out.println(result);
    
        
    }

    /**
     * Test of addAll method, of class MyDLL.
     */
    @Test
    public void testAddAll() {
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        
        MyDLLTest.addAll(instance);
        int expResult = 10;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of get method, of class MyDLL.
     */
    @Test
    public void testGet() {
        var result = MyDLLTest.get(5);
        int expResult = 6;
        assertEquals(expResult,result);
        
        
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemove_int() {
        var result = MyDLLTest.get(2);
        String expResult = "three";
        assertEquals(expResult,result);
        
        
        MyDLLTest.remove(2);
        
        var result2 = MyDLLTest.get(2);
        String expResult2 = "4";
        assertEquals(expResult2,result2);
 
    }

    /**
     * Test of remove method, of class MyDLL.
     */
    @Test
    public void testRemove_GenericType() {
        
        
        Object removedNode;
        removedNode = MyDLLTest.remove("three");
        System.out.println("This is the value of the removed Node:" + removedNode);
        
    }

    /**
     * Test of set method, of class MyDLL.
     */
    @Test
    public void testSet() {
        
        var result = MyDLLTest.set(0, "one");
        int expResult = 1;
        assertEquals(expResult, result);
        
        var result2 = MyDLLTest.get(0);
        String expResult2 = "one";
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of isEmpty method, of class MyDLL.
     */
    @Test
    public void testIsEmpty() {
        
        
        int expResult = 6;
        int result = MyDLLTest.size();
        assertEquals(expResult, result);
        MyDLLTest.clear();
        int expResult2 = 0;
        int result2 = MyDLLTest.size();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of contains method, of class MyDLL.
     */
    @Test
    public void testContains() {
       
        
        assertTrue(MyDLLTest.contains(1));
        System.out.println("the return of contains() for Int 1 is: " + MyDLLTest.contains(1));
        
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_GenericType() {
        
        
        
        Object newArray[] = new Object[10];
        
        MyDLLTest.toArray(newArray);
        
        
        assertEquals(MyDLLTest.get(0),newArray[0]);
        assertEquals(MyDLLTest.get(1),newArray[1]);
        assertEquals(MyDLLTest.get(2),newArray[2]);
        assertEquals(MyDLLTest.get(3),newArray[3]);
        assertEquals(MyDLLTest.get(4),newArray[4]);
        assertEquals(MyDLLTest.get(5),newArray[5]);
        
        
    }

    /**
     * Test of toArray method, of class MyDLL.
     */
    @Test
    public void testToArray_0args() {
        Object newArray[] = MyDLLTest.toArray();
        
        assertEquals(MyDLLTest.get(0),newArray[0]);
        assertEquals(MyDLLTest.get(1),newArray[1]);
        assertEquals(MyDLLTest.get(2),newArray[2]);
        assertEquals(MyDLLTest.get(3),newArray[3]);
        assertEquals(MyDLLTest.get(4),newArray[4]);
        assertEquals(MyDLLTest.get(5),newArray[5]);
        
        
    }

    /**
     * Test of iterator method, of class MyDLL.
     */
    @Test
    public void testIterator() {
        
        
        Iterator<Object> iterator = MyDLLTest.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2.0, iterator.next());
        assertEquals("three", iterator.next());
        
        
      
    }

    
}
