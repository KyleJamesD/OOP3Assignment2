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
 * The QueueADT interface adds an element to the end of the queue,
 * removes the element from the front of the queue, i.e. First in, 
 * first out (FIFO)
 * @param <E> The type of elements held in this queue
 */
public interface QueueADT<E> {
    /**
     * Inserts the specified element into the queue
     * @param element The element to be inserted
     * @throws NullPointerException if the specified element is null
     */
    public void enenque(E element) throws NullPointerException;
    
    /**
     * Removes and returns the element at the front of the queue
     * @return The element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue() throws NoSuchElementException;
    
    /**
     * Returns the element at the front of the queue
     * @return The element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E peek() throws NoSuchElementException;
    
    /**
     * Returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size();
    
    /**
     * Returns true if the queue contains no elements
     * @return true if the queue contains no elements
     */
    public boolean isEmpty();
    
}
