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
        
        
    }
    
    MyStack instance;
    
    @Before
    public void setUp() {
        
        instance = new MyStack<>();
        
        
    }

    /**
     * Test of push method, of class StackADT.
     */
    @Test
    public void testPush() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        instance.push(4.0);
        assertEquals(4.0,instance.peek()); 
        
    }

    /**
     * Test of pop method, of class StackADT.
     */
    @Test
    public void testPop() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        instance.push(4.0);
        
        Object expectedresult = instance.pop();
        assertEquals(4.0,expectedresult);
        instance.pop();
        instance.pop();
        instance.pop();
        //instance.push(1.0);
        Object isEmpty = instance.isEmpty();
        assertEquals(true,isEmpty);
    }

    /**
     * Test of peek method, of class StackADT.
     */
    @Test
    public void testPeek() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
       Object peeked =  instance.peek();
       assertEquals(peeked,3.0);
       
       
       Object isEmpty = instance.isEmpty();
       assertEquals(false,isEmpty);
    }

    /**
     * Test of clear method, of class StackADT.
     */
    @Test
    public void testClear() {
        instance.push(3.0);
        Object isEmpty = instance.isEmpty();
       assertEquals(false,isEmpty);
       
       
       instance.clear();
       Object isEmpty2 = instance.isEmpty();
       assertEquals(true,isEmpty2);
       
       
    }

    /**
     * Test of isEmpty method, of class StackADT.
     */
    @Test
    public void testIsEmpty() {
        instance.push(3.0);
        Object isEmpty = instance.isEmpty();
       assertEquals(false,isEmpty);
       
       
       instance.pop();
       Object isEmpty2 = instance.isEmpty();
       assertEquals(true,isEmpty2);
        
        
    }

    /**
     * Test of toArray method, of class StackADT.
     */
    @Test
    public void testToArray_0args() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        Object[] newarray2 = instance.toArray();
        
        
        
        assertEquals(1.0,newarray2[0]);
        assertEquals(2.0,newarray2[1]);
        assertEquals(3.0,newarray2[2]);
        
        
    }

    /**
     * Test of toArray method, of class StackADT.
     */
    @Test
    public void testToArray_GenericType() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
        
        Object[] newarray = new Object[10];
        
        Object[] newarray2 = instance.toArray(newarray);
        System.out.println("The array that had enough space for all the items index 0 is ="+newarray2[0]);
        System.out.println("The array that had enough space for all the items index 1 is ="+newarray2[1]);
        System.out.println("The array that had enough space for all the items index 2 is ="+newarray2[2]);
        
        
        Object[] newarray3 = new Object[2];
        
        Object[] newarray4 = instance.toArray(newarray3);
        System.out.println("The array that did not have enough space for all the items index 0 is ="+newarray4[0]);
        System.out.println("The array that did not have enough space for all the items index 1 is ="+newarray4[1]);
        System.out.println("The array that did not have enough space for all the items index 2 is ="+newarray4[2]);
        
        
        assertEquals(newarray2[0],newarray4[0]);
        assertEquals(newarray2[1],newarray4[1]);
        assertEquals(newarray2[2],newarray4[2]);
        
        assertEquals(1.0,newarray2[0]);
        assertEquals(2.0,newarray2[1]);
        assertEquals(3.0,newarray2[2]);
    }

    /**
     * Test of contains method, of class StackADT.
     */
    @Test
    public void testContains() {
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
        
        
       Object expectedResult = instance.contains(3.0);
       assertEquals(true,expectedResult);
       
       
       Object expectedResult2 = instance.contains(4.0);
       assertEquals(false,expectedResult2);
       
       
       
       
    }

    /**
     * Test of search method, of class StackADT.
     */
    @Test
    public void testSearch() {
       instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
        
       int result1 = instance.search(1.0);
       int result2 = instance.search(2.0);
       int result3 = instance.search(3.0);
       
       assertEquals(0,result1);
       assertEquals(1,result2);
       assertEquals(2,result3);
       assertNotEquals(3,result3);
       
    }

    /**
     * Test of iterator method, of class StackADT.
     */
    @Test
    public void testIterator() {
        
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
        
        
        Iterator<Object> iterator = instance.iterator();
        
        
        assertTrue(iterator.hasNext());
        assertEquals(1.0, iterator.next());
        assertEquals(2.0, iterator.next());
        assertEquals(3.0, iterator.next());
    }

    /**
     * Test of equals method, of class StackADT.
     */
    @Test
    public void testEquals() {
        
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
        
        MyStack instance2 = new MyStack<>();
        instance2.push(1.0);
        instance2.push(2.0);
        instance2.push(3.0);
        boolean result = instance.equals(instance2);
        assertEquals(true,result);
        
        
        MyStack instance3 = new MyStack<>();
        instance3.push(1.0);
        instance3.push(2.0);
        instance3.push(25.0);
        boolean result2 = instance.equals(instance3);
        assertEquals(false,result2);
        
        
        
        
        
    }

    /**
     * Test of size method, of class StackADT.
     */
    @Test
    public void testSize() {
        
        instance.push(1.0);
        instance.push(2.0);
        instance.push(3.0);
        
       int result = instance.size();
       assertEquals(3,result);
        
        
    }

    
}
