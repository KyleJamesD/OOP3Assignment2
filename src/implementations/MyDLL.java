package src.implementations;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<MyDLLNode<E>>{

    public MyDLLNode<E> head;
    public MyDLLNode<E> tail;
    private int size;
    private int DEFAULT_CAPACITY = 20;

    public MyDLL() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, MyDLLNode<E> toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > DEFAULT_CAPACITY) throw new IndexOutOfBoundsException();
        if (toAdd == null) throw new NullPointerException();
        if(isEmpty()){
            head = tail = toAdd;
        }
        if (index == 0){
            toAdd.next = head;
            head.prev = toAdd;
            head = toAdd;
        }
        else if (index == size){
            tail.next = toAdd;
            toAdd.prev = tail;
            tail = toAdd;
        }
        else {
            MyDLLNode<E> currentNode = get(index);
            toAdd.next = currentNode.next;
            toAdd.prev = currentNode;
            currentNode.next = toAdd;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(MyDLLNode<E> toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException();
        if (isEmpty()){
            head = tail = toAdd;
        }
        else {
            tail.next = toAdd;
            toAdd.prev = tail;
            tail = toAdd;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends MyDLLNode<E>> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        Iterator<? extends MyDLLNode<E>> iterator = toAdd.iterator();
        while (iterator.hasNext()){
            this.add(iterator.next());
        }
        return true;
    }

    @Override
    public MyDLLNode<E> get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) return head;
        MyDLLNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public MyDLLNode<E> remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyDLLNode<E> node = get(index);
        if (size == 1){
            head = tail = null;
        }
        else if (index == 0){
            head.next.prev = null;
            head = head.next;
        }
        else if (index == size-1){
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            MyDLLNode<E> previousNode = get(index - 1);
            node = previousNode.next;
            previousNode.next = previousNode.next.next;
        }
        size--;
        return node;
    }

    @Override
    public MyDLLNode<E> remove(MyDLLNode<E> toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException();
        if (size == 1){
            head = tail = null;
        }
        else {
            Iterator<MyDLLNode<E>> iterator = new MyDLLIterator();
            MyDLLNode<E> node;
            while (iterator.hasNext()){
                node = iterator.next();
                if (toRemove.data.equals(node.data)){
                    MyDLLNode<E> tempNode = node.prev;
                    tempNode.next = node.next;
                }
            }
        }
        size--;
        return toRemove;
    }

    @Override
    public MyDLLNode<E> set(int index, MyDLLNode<E> toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (toChange == null) throw new NullPointerException();
        MyDLLNode<E> node = get(index -1);
        MyDLLNode<E> tempNode = node.next;
        node.next = toChange;
        toChange.prev = node;
        tempNode.prev = toChange;
        toChange.next = tempNode;
        return toChange;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(MyDLLNode<E> toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException();
        Iterator<MyDLLNode<E>> iterator = new MyDLLIterator();
        while (iterator.hasNext()){
            if (toFind.data.equals(iterator.next().data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public MyDLLNode<E>[] toArray(MyDLLNode<E>[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException();
        if (toHold.length < size) return (MyDLLNode<E>[]) new Object[size];
        Iterator<MyDLLNode<E>> iterator = new MyDLLIterator();
        int index = 0;
        while (iterator.hasNext()){
            toHold[index] = iterator.next();
            index++;
        }
        if (toHold.length > size) toHold[size] = null;
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Iterator<MyDLLNode<E>> iterator = new MyDLLIterator();
        int i = 0;
        while (iterator.hasNext()){
            array[i] = iterator.next().data;
            i++;
        }
        return array;
    }

    @Override
    public Iterator<MyDLLNode <E>> iterator() {
        return new MyDLLIterator();
    }


    private class MyDLLIterator implements Iterator<MyDLLNode <E>>{
        private MyDLLNode<E> currentNode = head;
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
}
