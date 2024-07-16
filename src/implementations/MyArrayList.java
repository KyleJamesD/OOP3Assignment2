/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.Arrays;
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
    public E[] data;

    public MyArrayList() {
        data = (E[]) new Object[capacity];
        size = 0;
    }
    
  

    
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        size = 0;
        this.data = (E[])new Object[capacity];
    }

    public MyArrayList(int capacity, E[] data) {
        this.capacity = capacity;
        this.data = (E[])new Object[capacity];
        setData(data);
    }
    
    public MyArrayList(E[] data) {
        this.data = (E[])new Object[capacity];
        setData(data);
    }

    
    //if an array is passed this method will parse the Array into our new Array
    
    public final void setData(E[] data) {
        for(int i = 0; i < data.length; i++)
            if (data[i] != null) {
            this.data[i] = data[i];
            this.size++;
            }
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
            //the array is already full
            return false;
        }
        else{
        for (int i = size-1; i>=index; i--)
        {data[i+1] = data[i];}
          
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
        
        // NEED TO CHANGE SO THAT A NEW BIGGGER ARRAY IS CREATED IF NOT ENOUGH ROOM
        if (size + toAdd.size() > capacity)
        {return false;}
        
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

        if(index >= size)
            throw new IndexOutOfBoundsException("Index cannot be bigger then curent Size of the List");
        
        E removed = data[index];
        
        
        
        if(index == size-1){
        data[index] = null;
        }
        else
        {
        for (int i = index; i<size-1; i++)
            data[i] = data[i+1];
        } 
        
        size--;
        return removed;
        

    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        
        for (int i = 0; i < size; i++){
            if (data[i].equals(toRemove) ){
                E toReturn = data[i];
                data[i] = null;
                return toReturn;
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if(index >= size)
            throw new IndexOutOfBoundsException("Index cannot be bigger then curent Size of the List");
        
        
        E toReturn;
        toReturn = data[index];
        data[index] = toChange;
        return toReturn;

    }

    @Override
    public boolean isEmpty() {
        return size==0;
        

    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        
        for(int i=0; i < size;i++){
        if (data[i].equals(toFind))
        {return true;}
        }
        return false;


    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        
        if (toHold == null) {
            throw new NullPointerException("The specified array is null. Please Intialize before passing (you probably only declared it n00b).");
        }
        
        
        if(toHold.length >= capacity){
            for(int i=0; i < size; i++){
                toHold[i] = data[i];
            }
            return toHold;
            
        }
        
        
        /*
        Not the most efficient way to create a new array
        
        int newArraySize = toHold.length;
        while(newArraySize < capacity){  
            newArraySize++;
            //newArraysize = newArraySize*2;
        }
        E[] newArray =(E[]) new Object[newArraySize];
        */
        
        
        //if To hold is not big enough create a new array and set to size of MyArrayList and return that instead
        // generic type arrays cannot be created so cheat by casting to generic from object array
        
        //.lenght RETURNS HOW MANY OBJECTS THE ARRRAY CAN HOLD NOT HOW MANY ELEMENTS ARE IN THE ARRAY
        E[] newArray =(E[]) new Object[capacity];
        
        for(int i=0; i < newArray.length; i++){
                newArray[i] = data[i];
            }
            return newArray;

    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data,size);

    }
    
    
    
    
    
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }
    
    
    

    
    
    private class MyArrayListIterator implements Iterator<E>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            return data[index++];
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*   ************************OLD METHOD****************************
    @Override
    public Iterator<E> iterator() {
        
        GenericIterator iterator = new GenericIterator(data);
        return iterator;
        
    }
    
    */

    
    
    /*
    //is this correct??
    @Override
        public boolean hasNext() {
            int index = 0;
            return index < data.length;
        }

        
        
        @Override
        public E next()throws NoSuchElementException{
            
            //will return null elements in the array
            int index = 0;
            if(index < data.length)
            {return data[index++];}

            throw new NoSuchElementException();

        }
        
        */

 

  

    

        
        
        
        //end of class 
}


