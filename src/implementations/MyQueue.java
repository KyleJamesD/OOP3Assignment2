/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import exceptions.EmptyQueueException;
import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.QueueADT;

/**
 *
 * @author Will
 */
public class MyQueue<E> implements QueueADT<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element to queue");
        }
        Node<E> newNode = new Node<>(toAdd);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return front.data;
    }

    @Override
    public void dequeueAll() {
        front = rear = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }   

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();
        while (thisIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> current = front;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
            throw new NullPointerException("Holder array cannot be null");
        }
        if (holder.length < size) {
            holder = (E[]) java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), size);
        }
        Node<E> current = front;
        int i = 0;
        while (current != null) {
            holder[i++] = current.data;
            current = current.next;
        }
        if (holder.length > size) {
            holder[size] = null;
        }
        return holder;
    }

    @Override
    public boolean isFull() {
        return false; // This implementation does not have a fixed capacity
    }

    @Override
    public int size() {
        return size;
    }
}