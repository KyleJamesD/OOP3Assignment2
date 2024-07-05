/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utilities;

/**
 * 
 * 
 * 
 * 
 * Class Definition: This interface represent the public contract for the implementation of a Queue ADT. The Queue must be 
 * able to enqueue (add) elements to the front of the queue, to dequeue (remove) elements from the front of the Queue
 * to peek at the elements in the queue and check to see if the object is located in the Queue.
 * 
 * 
 * 
 * @param <E> the type of elements held in the Queue
 * @author kyled
 * 
 */
public interface QueueADT<E> {
    
    
    /**
     * 
     * The Element must be added to the Tail of the Queue
     * 
     * 
     * @param t The object to be added
     * @throws ElementIsNullException If the element is null
     */
    public void enqueue (E e);
    
    
    
    /**
     *
     * Removes the object from the Front of the Queue and returns it.
     * 
     * @return The front object of the queue
     * @throws QueueIsEmptyException if the Queue is empty
     */
    public E dequeue();
    
    
    
    
    /**
     * 
     * Returns the object from the front of the Queue without removing it form the Queue
     * 
     * @return The front Object of the Queue
     * @throws QueueIsEmptyException if the Queue is empty
     */
    public E peek();
    
    
    
    /**
     *
     * Returns true if the object is within the queue
     * 
     * @param t
     * @return true if the object is in the queue
     * @return false if the object is not in the queue
     * @throws QueueIsEmptyException if the Queue is empty
     */
    public boolean checkQueue(E e);
    
    /**
     * 
     * Checks if the Queue is empty
     * 
     * @return true if the queue is empty
     * @return false if the queue is not empty
     */
    public boolean isEmpty();
    
    
}
