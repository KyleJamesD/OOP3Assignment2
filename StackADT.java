/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utilities;

import java.util.NoSuchElementException;

/**
 *
 * @author Will
 * 
 * The StackADT interface represents the contract for a stack data structure.
 * It adds an element to the collection and removes the most recently added 
 * element that has not yet been removed, i.e. Last in, first out (LIFO)
 * @param <E> The type of elements held in this stack
 */
public interface StackADT<E> {
    /**
     * Pushes an element onto the top of the stack
     * @param element The element to be pushed onto the stack
     * @throws NullPointerException if the specified element is null
     */
    public void push(E element) throws NullPointerException;

    /**
     * Removes and returns the element at the top of the stack
     * @return The element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public E pop() throws NoSuchElementException;
    
    /**
     * Returns the element at the top of the stack
     * @return The element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public E peek() throws NoSuchElementException;
    
    /**
     * Returns the number of elements in the stack
     * @return The number of elements in the stack
     */
    public int size();
    
    /**
     * Returns true if the stack contains no elements
     * @return true if the stack contains no elements
     */
    public boolean isEmpty();
}
