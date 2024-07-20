/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;
import utilities.ListADT;

/**
 *
 * @author Will
 */
public class MyDLL<E> implements ListADT<E> {
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (toAdd == null) throw new NullPointerException("Element cannot be null");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) tail.next = newNode;
            tail = newNode;
        } else {
            MyDLLNode<E> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        return add(size, toAdd);
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
        return getNode(index).data;
    }

    private MyDLLNode<E> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        MyDLLNode<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public E remove(int index) {
        MyDLLNode<E> node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
        return node.data;
    }

    @Override
    public E remove(E toRemove) {
        if (toRemove == null) throw new NullPointerException("Element cannot be null");
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.data)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                size--;
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) {
        if (toChange == null) throw new NullPointerException("Element cannot be null");
        MyDLLNode<E> node = getNode(index);
        E oldData = node.data;
        node.data = toChange;
        return oldData;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        if (toFind == null) throw new NullPointerException("Element cannot be null");
        MyDLLNode<E> current = head;
        while (current != null) {
            if (toFind.equals(current.data)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) {
        if (toHold == null) throw new NullPointerException("Array cannot be null");
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }
        int i = 0;
        MyDLLNode<E> current = head;
        while (current != null) {
            toHold[i++] = current.data;
            current = current.next;
        }
        if (toHold.length > size) toHold[size] = null;
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        MyDLLNode<E> current = head;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private MyDLLNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
