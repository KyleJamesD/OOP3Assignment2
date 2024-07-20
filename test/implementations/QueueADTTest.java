/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package implementations;

import exceptions.EmptyQueueException;
import org.junit.Before;
import org.junit.Test;
import utilities.Iterator;
import utilities.QueueADT;
import static org.junit.Assert.*;

/**
 *
 * @author kyled
 */
public class QueueADTTest {
    
    public QueueADTTest() {
    }
    MyQueue instance;
    
    
    
    @Before
    public void setUp() {    
        
    }

    /**
     * Test of enqueue method, of class QueueADT.
     */
    @Test
    public void testEnqueue() throws Exception {
        
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        
        Object expResult = instance.peek();
        assertEquals(1,expResult);
        
     
        
    }

    /**
     * Test of dequeue method, of class QueueADT.
     */
    @Test
    public void testDequeue() throws Exception {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        Object expResult1 = instance.dequeue();
        assertEquals(1,expResult1);
        
        
        Object expResult2 = instance.peek();
        assertEquals(2.0,expResult2);
        
        
    }

    /**
     * Test of peek method, of class QueueADT.
     */
    @Test
    public void testPeek() throws Exception {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        
        Object expResult3 = instance.peek();
        assertEquals(1,expResult3);
        
        Object expResult1 = instance.peek();
        assertNotEquals(2.0,expResult1);
        
        
        Object expResult2 = instance.peek();
        assertNotEquals("three",expResult2);
        
        
        
        
        
        
    }

    /**
     * Test of dequeueAll method, of class QueueADT.
     */
    @Test
    public void testDequeueAll() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        
        instance.dequeueAll();
        
       boolean expresult = instance.isEmpty();
       assertEquals(true,expresult);
       
    }

    /**
     * Test of isEmpty method, of class QueueADT.
     */
    @Test
    public void testIsEmpty() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        boolean expresult = instance.isEmpty();
        
        assertEquals(false,expresult);
        
        
        instance.dequeueAll();
        boolean expresult2 = instance.isEmpty();
        
        assertEquals(true,expresult2);
        
        
        
    }

    /**
     * Test of iterator method, of class QueueADT.
     */
    @Test
    public void testIterator() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        
        Iterator<Object> iterator= instance.iterator();
        
        assertEquals(1,iterator.next());
        assertEquals(2.0,iterator.next());
        assertEquals("three",iterator.next());
        
        
        
    }

    /**
     * Test of equals method, of class QueueADT.
     */
    @Test
    public void testEquals() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        MyQueue instance2 = new MyQueue<>();
        instance2.enqueue(1);
        instance2.enqueue(2.0);
        instance2.enqueue("three");
        
 
        boolean expResult = instance.equals(instance2);
        assertEquals(true,expResult);
        
        
        
        
    }

    /**
     * Test of toArray method, of class QueueADT.
     */
    @Test
    public void testToArray_0args() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        Object[] newarray2 = instance.toArray();
        
        assertEquals(1,newarray2[0]);
        assertEquals(2.0,newarray2[1]);
        assertEquals("three",newarray2[2]);
        
        
        
        
    }

    /**
     * Test of toArray method, of class QueueADT.
     */
    @Test
    public void testToArray_GenericType() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        //array with enough space
        Object[] newarray = new Object[10];
        newarray = instance.toArray(newarray);
        assertEquals(1,newarray[0]);
        assertEquals(2.0,newarray[1]);
        assertEquals("three",newarray[2]);
        
        //array with not enough space new one wil be created
        Object[] newarray3 = new Object[2];  
        newarray3 = instance.toArray(newarray3);
        assertEquals(1,newarray3[0]);
        assertEquals(2.0,newarray3[1]);
        assertEquals("three",newarray3[2]);
        
        
    }

    /**
     * Test of isFull method, of class QueueADT.
     */
    @Test
    public void testIsFull() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        //a full Queue returns true
        boolean expResult = instance.isFull();
        assertEquals(true,expResult);
        
        
        //not full queue returns false
        MyQueue instance2 = new MyQueue<>();
        instance2.enqueue(1); 
        instance2.enqueue(2.0);
        instance2.enqueue("three");
        instance2.enqueue(1);
        instance2.enqueue(2.0);
        instance2.enqueue("three");
        instance2.enqueue(1);
        instance2.enqueue(2.0);
        instance2.enqueue("three");

        
        boolean expResult2 = instance2.isFull();
        assertEquals(false,expResult2);
        
        
        
    }

    /**
     * Test of size method, of class QueueADT.
     */
    @Test
    public void testSize() {
        instance = new MyQueue<>();
        instance.enqueue(1);
        instance.enqueue(2.0);
        instance.enqueue("three");
        
        
        int expResult = instance.size();
        
        assertEquals(3,expResult);
        
        
        
        
        
    }

    
}
