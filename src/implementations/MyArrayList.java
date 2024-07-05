/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author kyled
 */
public class MyArrayList<E> implements ListADT<E> {
    

    //size is the current element count of the list, when new list is created this will always be zero
    private int size;
    //capacity is the total amount of elements the list can hold, default is 10.
    public int capacity = 10;
    //The underlying Data structure to store the elements in this list, a Regular Array.
    E[] data;
    
  

    
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        size = 0;
        this.data = (E[])new Object[capacity];
    }

    public MyArrayList(int capacity, E[] data) {
        this.capacity = capacity;
        this.size = data.length;
        
        this.data = (E[])new Object[capacity];
        setData(data);
    }

    
    //if an array is passed this method will parse the Array into our new Array
    public final void setData(E[] data) {
        for(int i = 0; i <size; i++)
            this.data[i] = data[i];
        this.size = data.length;
    }
    
    
   //returns the current amount of elements in the list, can be 0-10
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //set the size of the array back to zero
        size = 0;
        //Set the array to a new empty array
        this.data = (E[])new Object[capacity];
        
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        
        //index = 0-9 must use zero based indexing
        //capacity = 1 - 10 or whatever is set
        //data = 0-9
        //size = 0 - 10 or whatever is set, can be zero if list is empty
        if(index >= capacity || index < 0 ){
            throw new IndexOutOfBoundsException("The given location is beyond the capacity or less then zero.");
        }
        else if (size == capacity){
            return false;
        }
        else{
        for (int i = size-1; i>=index; i--)
            data[i+1] = data[i];
          
        data[index] = toAdd;
        size++;
        return true;
        }
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        
        if (size == capacity){
        return false;
        }
        
        data[size] = toAdd;
        size++;
        return true;
    }
    
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        
        if (toAdd == null) {
        throw new NullPointerException("The collection to add cannot be null.");
        }
        
        //this calls the object.iterator(); method, NOT MYARRAYLISTS iterator();
        
        //they both have a function with the same name because they both implement ListADT
        //toAdd has its own implementation of iterator().
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();


            data[size] = element;
            size++;
        }
        return true;

        }



    @Override
    public E get(int index) throws IndexOutOfBoundsException {

        if(index >= capacity)
            throw new IndexOutOfBoundsException("Index cannot be bigger then capactiy");
        
        return data[index];


    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {

        if(index >= capacity)
            throw new IndexOutOfBoundsException("Index cannot be bigger then capactiy");
        
        E removed = data[index];
        for (int i = index; i<size-1; i++)
            data[i] = data[i+1];
          
        
        size--;
        return removed;
        

    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        
        GenericIterator iterator = new GenericIterator(data);
        return iterator;
        
    }
        
        

 

  

    
    
}


