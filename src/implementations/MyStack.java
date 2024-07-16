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

    private final MyArrayList<E> list;
    private final int size;

    public MyStack() {
        list = new MyArrayList<E>();
        size = 0;
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if(toAdd == null){
        throw new NullPointerException();}
        
        
        list.add(0, toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        MyArrayList<E> temp = list;
        if (size == 1) return list.remove(0);
        else return list.remove(size-1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        return list.get(1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return list.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        Iterator<E> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().equals(toFind)) {
                return list.size()-index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (that == this) return true;
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }
}