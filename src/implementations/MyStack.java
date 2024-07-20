package src.implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {

    private MyArrayList<E> list;
    private int size;

    public MyStack() {
        list = new MyArrayList<>();
        size = 0;
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        list.add(0, (E) toAdd);
        size += 1;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        E temp = list.get(0);
        list.remove(0);
        size -= 1;
        return temp;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        return list.get(0);
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
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
        return new MyStackIterator();
    }

    private class MyStackIterator implements Iterator<E>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            return list.get(index++);
        }
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (that == this) return true;
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();
        while (thisIterator.hasNext() && thatIterator.hasNext()) {
            if (!thisIterator.next().equals(thatIterator.next())) {
                return false;
            }
        }
        return !thisIterator.hasNext() && !thatIterator.hasNext();
    }

    @Override
    public int size() {
        return list.size();
    }
}
