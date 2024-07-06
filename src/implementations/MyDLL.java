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
 * @author kyled
 */
public class MyDLL<E> implements ListADT<E>,Iterator<Node> {

    
    private Node<E> head;
    private Node<E> tail;
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
        
        if (toAdd == null){
            throw new NullPointerException("");
        }
        
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(toAdd);
        if(size == 0){
            newNode.next = null;
            newNode.previous = null;
            head = newNode;
            tail = newNode;
            size++;
            return true;
        }
        
        else if(index == 0){
            newNode.next = head;
            head.previous = newNode;
            newNode.previous = null;
            head = newNode;
            size++;
            return true;
        }
        
        
        else if (index == size){
            newNode.previous = tail;
            tail.next = newNode;
            newNode.next = null;
            tail = newNode;
            size++;
            return true;        
        }

        else{
            Node<E> current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index-1; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index-1; i--) {
                    current = current.previous;
                }
            }
            
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
            size++;
            return true;
        }
        
        
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        Node newNode = new Node(toAdd);
        if(size == 0){
            newNode.next = null;
            newNode.previous = null;
            head = newNode;
            tail = newNode;
            size++;
        return true;
        }
        
        newNode.previous = tail;
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

        if (toAdd == null) {
        throw new NullPointerException("The collection to add cannot be null.");
        }
        
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;

    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<E> current;
        if(size == 1){
        return head.value;
        }
        
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }

        return current.value;
    }

    

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        
        
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        
        
        //to remove the element at the head
        if(index == 0 && size != 1){
            E toReturn = head.value;
            head = head.next;
            head.previous = null;
            size --;
            return toReturn;
        }
        
        //if there is only one element in the list
        else if(index == 0 && size == 1){
            E toReturn = head.value;
            head = null;
            tail = null;
            size --;
            return toReturn;
        }
         
        // to remove the tail of the list, 
        //this should not execute if there is only 1 element as setting tail.next to null would cause a null pointer exception, this is why we have the else if statement for else if(index == 0 && size == 1) one item in the list.
        // this statement will execute if there are two or more items in the list and the index == the tail position.
        else if(index == size-1){
            E toReturn = tail.value;
            tail = tail.previous;
            tail.next=null;
            size --;
            return toReturn;
        }
        
        Node<E> current;
        //to remove all other elements
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size --;
        return current.value;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

        


    }

    @Override
    public boolean isEmpty() {
        return size == 0;

        }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Node next() throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
}
