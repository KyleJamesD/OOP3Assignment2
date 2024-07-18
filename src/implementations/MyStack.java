/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.EmptyStackException;
import utilities.Iterator;
import utilities.ListADT; 
import utilities.StackADT;
/**
 *
 * @author kyled
 */


public class MyStack<E extends MyArrayList<E>> implements StackADT<E>{

    private final MyArrayList<E> stackArray;
    public int size;

    public MyStack() {
        stackArray = new MyArrayList<E>();
        size = 0;
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if(toAdd == null){
        throw new NullPointerException();}
        
        
        stackArray.add(size,toAdd);
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        
        if (size == 1) {
        size--;
        return stackArray.remove(0);
        }
        
        
        else{
            int index = size;
            size--;
            //can this also be achieved with return stackArray.remove(size--);
            return stackArray.remove(index-1);
        }
        
        
    }

    @Override
    public E peek() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        return stackArray.get(size-1);
    }

    @Override
    public void clear() {
        stackArray.clear();
    }

    @Override
    public boolean isEmpty() {
        return stackArray.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return stackArray.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return stackArray.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stackArray.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        Iterator<E> it = stackArray.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().equals(toFind)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return stackArray.iterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        Iterator<E> thisIterator = this.iterator();
        Iterator<?> thatIterator = that.iterator();
        
       
        boolean x = false;
        
        if(this.size != that.size())
        {return false;}
        
       
        
        while(thisIterator.hasNext() && thatIterator.hasNext())
        {
            if(thisIterator.next().equals(thatIterator.next()))
            {
            x = true;

            }
            else 
            {return false;}
        }
        return x;   
        
    }

    @Override
    public int size() {
        return stackArray.size();
    }
}
