package src.utilities;


import src.ListADT;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements ListADT<E> {
    private int size;
    private Object[] elenments;
    private int capacity = 10;
    private int extendRatio = 2;

    public MyArrayList() {
        size = 0;
        elenments = new Object[capacity];
    }

    private E elementData(int index) {
        checkIndex(index);
        return (E) elenments[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elenments[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        checkIndex(index);
        if (size == capacity) {
            extendCapacity();
        }
        System.arraycopy(elenments, index,
                elenments, index + 1,
                size - index);
        elenments[index] = toAdd;
        size++;
        return true;
    }

    private void extendCapacity() {
        extendCapacity(capacity = capacity * extendRatio);
    }

    private void extendCapacity(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        if (size >= 0) System.arraycopy(elenments, 0, newElements, 0, size);
        elenments = newElements;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (size == capacity) {
            extendCapacity();
        }
        elenments[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        if (toAdd.isEmpty()) {
            return false;
        }
        if (this.size() + toAdd.size() > capacity) {
            extendCapacity(capacity = capacity + toAdd.size());
        }
        System.arraycopy(toAdd.toArray(), 0, elenments, size, toAdd.size());
        size += toAdd.size();
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return elementData(index);
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        E removed = elementData(index);
        if (index == size - 1) {
            elenments[--size] = null;
            return removed;
        }
        System.arraycopy(elenments, index + 1,
                elenments, index,
                size-- - index - 1);
        return removed;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        for (int i = 0; i < size; i++) {
            if (elenments[i].equals(toRemove)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        checkIndex(index);
        E oldValue = elementData(index);
        elenments[index] = toChange;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (elenments[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException();
        }
        if (toHold.length < size) {
            return (E[]) Arrays.copyOf(elenments, size, toHold.getClass());
        }
        System.arraycopy(elenments, 0, toHold, 0, size);
        return toHold;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elenments, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrIterator<>();
    }


    private class MyArrIterator<E> implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return (E) elenments[index++];
        }
    }
}
