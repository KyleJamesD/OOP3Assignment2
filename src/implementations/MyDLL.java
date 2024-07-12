package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E extends MyDLLNode<E>> implements ListADT<E>{

    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

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
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (toAdd == null) throw new NullPointerException();
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
            MyDLLNode<E> previousNode = get(index - 1);
            MyDLLNode<E> tempNode = previousNode.next;
            previousNode.next = toAdd;
            toAdd.prev = previousNode;
            toAdd.next = tempNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
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
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyDLLNode<E> node = head;
        Iterator<E> iterator = new MyDLLIterator();
        while (iterator.hasNext()){
            node = node.next;
        }
        return (E) node;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
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
        return (E) node;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException();
        if (size == 1){
            head = tail = null;
        }
        else {
            Iterator<E> iterator = new MyDLLIterator();
            MyDLLNode<E> node = null;
            while (iterator.hasNext()){
                node = iterator.next();
                if (toRemove.equals(node.data)){
                    MyDLLNode<E> tempNode = node.next;
                    node.next = tempNode.next;
                }
            }
        }
        size--;
        return toRemove;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
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
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException();
        Iterator<E> iterator = new MyDLLIterator();
        while (iterator.hasNext()){
            if (toFind.equals(iterator.next())){
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException();
        if (toHold.length < size) return (E[]) new Object[size];
        Iterator<E> iterator = new MyDLLIterator();
        int i = 0;
        while (iterator.hasNext()){
            toHold[i] = iterator.next();
            i++;
        }
        if (toHold.length > size) toHold[size] = null;
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Iterator<E> iterator = new MyDLLIterator();
        int i = 0;
        while (iterator.hasNext()){
            array[i] = iterator.next();
            i++;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    private class MyDLLIterator implements Iterator<E>{
        private MyDLL myDLL;
        private MyDLLNode currentNode;

        @Override
        public boolean hasNext() {
            return currentNode != null && currentNode.next != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();

            if(currentNode == null){
                currentNode = myDLL.head;
            }
            else {
                currentNode = currentNode.next;
            }
            return (E) currentNode;
        }
    }
}
