/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.io.Serializable;
import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author Will
 */
public class MyArrayList<E> implements ListADT<E> {
    private E[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (toAdd == null) throw new NullPointerException("Element cannot be null");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        if (toAdd == null) throw new NullPointerException("Element cannot be null");
        ensureCapacity(size + 1);
        elements[size++] = toAdd;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) {
        if (toAdd == null) throw new NullPointerException("Collection cannot be null");
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        return elements[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        E removedElement = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null; // clear to let GC do its work
        return removedElement;
    }

    @Override
    public E remove(E toRemove) {
        if (toRemove == null) throw new NullPointerException("Element cannot be null");
        for (int index = 0; index < size; index++) {
            if (toRemove.equals(elements[index])) {
                return remove(index);
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) {
        if (toChange == null) throw new NullPointerException("Element cannot be null");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        E oldElement = elements[index];
        elements[index] = toChange;
        return oldElement;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        if (toFind == null) throw new NullPointerException("Element cannot be null");
        for (E element : elements) {
            if (toFind.equals(element)) return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] toHold) {
        if (toHold == null) throw new NullPointerException("Array cannot be null");
        if (toHold.length < size) {
            return (E[]) java.util.Arrays.copyOf(elements, size, toHold.getClass());
        }
        System.arraycopy(elements, 0, toHold, 0, size);
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        return java.util.Arrays.copyOf(elements, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return elements[currentIndex++];
            }
        };
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) newCapacity = minCapacity;
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }
}