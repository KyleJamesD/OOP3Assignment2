package src.utilities;

import org.w3c.dom.Node;
import src.ListADT;

import java.util.Arrays;
import java.util.Iterator;

public class MyDLL<E> implements ListADT<E> {

    private int size;

    MyDLLNode<E> head;
    MyDLLNode<E> tail;

    public MyDLL() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (toAdd == null) {
            throw new NullPointerException("The element to add is null");
        }
        MyDLLNode<E> newNode = new MyDLLNode<>(null, toAdd, null);
        if (index == size) {
            return add(toAdd);
        }

        MyDLLNode<E> destNode = nodeAt(index);
        MyDLLNode<E> prevNode = destNode.prev;
        if (prevNode == null) {
            head = newNode;
        } else {
            prevNode.next = newNode;
            newNode.prev = prevNode;
        }
        newNode.next = destNode;
        destNode.prev = newNode;
        size++;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        MyDLLNode<E> newNode = new MyDLLNode<>(null, toAdd, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The list to add is null");
        }
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        MyDLLNode<E> node = nodeAt(index);
        return node.element;
    }

    private MyDLLNode<E> nodeAt(int index) {
        checkIndex(index);
        if (index < size / 2) {
            MyDLLNode<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            MyDLLNode<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        MyDLLNode<E> node = nodeAt(index);
        return removeNode(node);
    }

    private E removeNode(MyDLLNode<E> node) {
        MyDLLNode<E> prevNode = node.prev;
        MyDLLNode<E> nextNode = node.next;
        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }
        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }
        size--;
        return node.element;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (isEmpty()) {
            return null;
        }
        if (toRemove == null) {
            throw new NullPointerException("The element to remove is null");
        }
        MyDLLNode<E> findNode = findFirstNode(toRemove);
        if (findNode == null) {
            return null;
        }
        return removeNode(findNode);
    }

    private MyDLLNode<E> findFirstNode(E toFind) {
        if (toFind == null) {
            throw new NullPointerException("The element to find is null");
        }
        for (MyDLLNode<E> node = head; node != null; node = node.next) {
            if (toFind.equals(node.element)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        checkIndex(index);
        MyDLLNode<E> node = nodeAt(index);
        E oldValue = node.element;
        node.element = toChange;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("The element to find is null");
        }
        MyDLLNode<E> firstNode = findFirstNode(toFind);
        return firstNode != null;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("The array to hold is null");
        }
        if (toHold.length < size) {
            toHold = Arrays.copyOf(toHold, size);
        }
        Iterator<E> iterator = iterator();
        int index = 0;
        while (iterator.hasNext()) {
            toHold[index++] = iterator.next();
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        if (isEmpty()) {
            return objects;
        }
        Iterator<E> iterator = iterator();
        int index = 0;
        while (iterator.hasNext()) {
            objects[index++] = iterator.next();
        }
        return objects;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    private class MyDLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

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


    public static class MyDLLNode<E> {
        MyDLLNode<E> prev;
        E element;
        MyDLLNode<E> next;

        MyDLLNode(MyDLLNode<E> prev, E element, MyDLLNode<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
