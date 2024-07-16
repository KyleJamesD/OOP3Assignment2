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
public class MyQueue<E extends MyDLL<E>> implements QueueADT<E> {

    private MyDLL<E> list;
    private final int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        list = new MyDLL<>();
        size = 0;
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        list.add(toAdd);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (list.isEmpty()) throw new EmptyQueueException();
        E temp = list.get(0);
        list.remove(0);
        return temp;
    }

    @Override
    public E peek() throws EmptyQueueException {
        return list.get(0);
    }

    @Override
    public void dequeueAll() {
        list.clear();
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
        return that == this;
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
