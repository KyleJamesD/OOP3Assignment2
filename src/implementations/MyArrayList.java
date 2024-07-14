package src.implementations;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public MyArrayList(){
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (toAdd == null) throw new NullPointerException();
        if (size == array.length) array = Arrays.copyOf(array, array.length * 2);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = toAdd;
        size += 1;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException();
        if (size == array.length) array = Arrays.copyOf(array, array.length * 2);
        array[size] = toAdd;
        size += 1;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        if (size == array.length) array = Arrays.copyOf(array, array.length + toAdd.size());
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            array[size] = iterator.next();
            size += 1;
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        E temp = array[index];
        int indexToRemove = size - index - 1;
        if (indexToRemove > 0) System.arraycopy(array, index + 1, array, index, indexToRemove);
        size -= 1;
        array[size] = null;
        return temp;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException();
        Iterator<E> iterator = iterator();
        int indexToRemove = 0;
        while (iterator.hasNext()) {
            if (toRemove.equals(iterator.next())){
                remove(indexToRemove);
                return toRemove;
            }
            indexToRemove++;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (toChange == null) throw new NullPointerException();
        array[index] = toChange;
        return toChange;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException();
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (toFind.equals(iterator.next())) return true;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException();
        if (toHold.length < size) return Arrays.copyOf(array, size);
        System.arraycopy(array, 0, toHold, 0, size);
        return toHold;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            return array[index++];
        }
    }
}
