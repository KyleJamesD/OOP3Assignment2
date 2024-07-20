package src.implementations;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<MyDLLNode<E>> {

    private MyDLL<E> list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        list = new MyDLL<>();
        size = 0;
    }

    @Override
    public void enqueue(MyDLLNode<E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        list.add(toAdd);
        size++;
    }

    @Override
    public MyDLLNode<E> dequeue() throws EmptyQueueException {
        if (list.isEmpty()) throw new EmptyQueueException();
        MyDLLNode<E> temp = list.get(0);
        list.remove(0);
        size--;
        return temp;
    }

    @Override
    public MyDLLNode<E> peek() throws EmptyQueueException {
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
    public Iterator<MyDLLNode<E>> iterator() {
        return new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<MyDLLNode <E>>{
        private MyDLLNode<E> currentNode = list.head;
        private MyDLLNode<E> node;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public MyDLLNode<E> next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            node = currentNode;
            currentNode = currentNode.next;
            return node;
        }
    }

    @Override
    public boolean equals (QueueADT<MyDLLNode<E>> that) {
        if (this == that) return true;
        Iterator<MyDLLNode<E>> thisIterator = this.iterator();
        Iterator<MyDLLNode<E>> thatIterator = that.iterator();

        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            if (!thisIterator.next().data.equals(thatIterator.next().data)) {
                return false;
            }
        }
        return !thisIterator.hasNext() && !thatIterator.hasNext();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }


    @Override
    public MyDLLNode<E>[] toArray(MyDLLNode<E>[] holder) throws NullPointerException {
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
