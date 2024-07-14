package src.utilities;

import src.QueueADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> queue;

    public MyQueue() {
        queue = new MyDLL<>();
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        queue.add(toAdd);
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        return queue.remove(0);
    }

    @Override
    public E peek() throws NoSuchElementException {
        return queue.get(0);
    }

    @Override
    public void dequeueAll() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyQueueIterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        if (this == that) {
            return true;
        }
        if (this.size() != that.size()) {
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
        return queue.toArray();
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return queue.toArray(toHold);
    }

    @Override
    public boolean isFull() {
        // Queue is never full
        return false;
    }

    @Override
    public int size() {
        return queue.size();
    }

    private class MyQueueIterator implements Iterator<E> {
        private MyDLL.MyDLLNode<E> current = queue.head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
