/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;
import exceptions.EmptyQueueException;
import implementations.MyDLL;
import utilities.Iterator;
import utilities.Iterator;
import utilities.QueueADT;

/**
 *
 * @author kyled
 */
public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        list = new MyDLL<>();
        size = 0;
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        list.add(toAdd);
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (list.isEmpty()) throw new EmptyQueueException();
        E temp = list.get(0);
        list.remove(0);
        size--;
        return temp;
        
    }

    @Override
    public E peek() throws EmptyQueueException {
        if(size==0)
        {throw new EmptyQueueException();}
        return list.get(0);
    }

    @Override
    public void dequeueAll() {
        list.clear();
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
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
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return list.toArray(holder);
    }

    @Override
    public boolean isFull() {
        return list.size() >= DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }
}
