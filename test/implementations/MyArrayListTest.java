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
import java.util.NoSuchElementException;

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
        int capacity = 10;
        Double data1[] = new Double[10];
        data1[0] = 6.0;
        data1[1] = 7.0;
        data1[2] = 8.0;
        data1[3] = 9.0;
        data1[4] = 8.0;
        ListADT<Double> instance = new MyArrayList<>(capacity, data1);
        
        
        int index = 1;
        Double toSet = 22.0;
        Double toCheck = 7.0;
        Double result = instance.set(index, toSet);
        assertEquals(result, toCheck);
        assertEquals(instance.get(0), data1[0]);
        assertEquals(instance.get(1), toSet);
        assertEquals(instance.get(2), data1[2]);
        
    }

    /**
     * Test of isEmpty method, of class ListADT.
     */
    @Test
    public void testIsEmpty() {
        
        Double data1[] = new Double[10];
         ListADT<Double> instance = new MyArrayList<>(data1);
         boolean istrue = true;
         boolean isfalse = false;
         
         assertEquals(instance.isEmpty(), istrue);
         
         Double makefalse = 3.0;
         instance.add(makefalse);
         assertEquals(instance.isEmpty(), isfalse);
         
    }

    /**
     * Test of contains method, of class ListADT.
     */
    @Test
    public void testContains() {
        int capacity = 10;
        Object data1[] = new Object[10];
        
        Boolean booleanObjecttrue = true;
        data1[0] = (Double)6.0;
        data1[1] = (Integer)7;
        data1[2] = "Hello World";
        data1[3] = booleanObjecttrue;
        data1[4] = null;
        MyArrayList instance = new MyArrayList<>(capacity, data1);
        
        Double var1 = 6.0;
        Integer var2 = 7;
        String var3 = "Hello World";
        Boolean var4 = true;
        String var5 = null;
        
        boolean istrue = true;
         boolean isfalse = false;
        
        assertEquals(instance.contains(var1),istrue);
        assertEquals(instance.contains(var2),istrue);
        assertEquals(instance.contains(var3),istrue);
        assertEquals(instance.contains(var4),istrue);
        //assertEquals(instance.contains(var5),istrue);
        
        
        Double var6 = 6.01;
        Integer var7 = 77;
        String var8 = "Hello world1";
        Boolean var9 = false;
        
        assertEquals(instance.contains(var6),isfalse);
        assertEquals(instance.contains(var7),isfalse);
        assertEquals(instance.contains(var8),isfalse);
        assertEquals(instance.contains(var9),isfalse);
        
        
        
    }

    /**
     * Test of toArray method, of class ListADT.
     */
    @Test
    public void testToArray_GenericType() {
        int capacity = 10;
        Object data1[] = new Object[10];
        
        Boolean booleanObjecttrue = true;
        data1[0] = (Double)6.0;
        data1[1] = (Integer)7;
        data1[2] = "Hello World";
        data1[3] = booleanObjecttrue;
        data1[4] = null;
        MyArrayList instance = new MyArrayList<>(capacity, data1);
        
        
        Object data2[] = new Object[3];
        Object newdata2[] =  instance.toArray(data2);
        assertEquals(data1[0],newdata2[0]);
        assertEquals(data1[1],newdata2[1]);
        assertEquals(data1[2],newdata2[2]);
        assertEquals(data1[3],newdata2[3]);
        assertEquals(data1[4],newdata2[4]);
        
        
        
        
        Object data3[] = new Object[10];
        Object newdata3[] =  instance.toArray(data3);
        assertEquals(data1[0],newdata3[0]);
        assertEquals(data1[1],newdata3[1]);
        assertEquals(data1[2],newdata3[2]);
        assertEquals(data1[3],newdata3[3]);
        assertEquals(data1[4],newdata2[4]);
        
        
        Object newArray[] = instance.toArray();
        assertEquals(data1[0],newArray[0]);
        assertEquals(data1[1],newArray[1]);
        assertEquals(data1[2],newArray[2]);
        assertEquals(data1[3],newArray[3]);
        //assertEquals(data1[4],newArray[4]);
       
        
        
    }

    /**
     * Test of toArray method, of class ListADT.
     */
    @Test
    public void testToArray_0args() {
        
        int capacity = 10;
        Object data1[] = new Object[10];
        
        Boolean booleanObjecttrue = true;
        data1[0] = (Double)6.0;
        data1[1] = (Integer)7;
        data1[2] = "Hello World";
        data1[3] = booleanObjecttrue;
        data1[4] = null;
        MyArrayList instance = new MyArrayList<>(capacity, data1);

        Object newArray[] = instance.toArray();
        assertEquals(data1[0],newArray[0]);
        assertEquals(data1[1],newArray[1]);
        assertEquals(data1[2],newArray[2]);
        assertEquals(data1[3],newArray[3]);
        //assertEquals(data1[4],newArray[4]);
    }

    /**
     * Test of iterator method, of class ListADT.
     */
    @Test
    public void testIterator() {
        
        
        int capacity = 10;
        Object data1[] = new Object[10];
        
        Boolean booleanObjecttrue = true;
        data1[0] = (Double)6.0;
        data1[1] = (Integer)7;
        data1[2] = "Hello World";
        data1[3] = booleanObjecttrue;
        MyArrayList instance = new MyArrayList<>(capacity, data1);
           
        Iterator<Object> iterator = instance.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(6.0, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals("Hello World", iterator.next());
        assertEquals(booleanObjecttrue, iterator.next());
        assertThrows(NoSuchElementException.class,() -> iterator.next());

        assertFalse(iterator.hasNext());
        
        
        
    }


    
}
