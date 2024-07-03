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
 * to peek at the elemtns in the queue and check to see if the object is located in the Queue.
 * 
 * 
 * 
 * @param <T> the type of elements held in the Queue
 * @author kyled
 * 
 */
public interface QueueADT<T> {
    
    
    /**
     * Preconditions: 
     * The element to be added cannot be null
     * 
     * 
     * Post conditions:
     * The Element must be added to the Tail of the Queue
     * 
     * 
     * @param t The object to be added
     * @throws ElementIsNullException
     */
    public void enqueue (T t);
    
    
    
    /**
     * Preconditions: 
     * The Queue cannot be empty
     * 
     * 
     * Post conditions:
     * Removes the object from the Front of the Queue and returns it.
     * 
     * @return The front object of the queue
     * @throws QueueIsEmptyException if the Queue is empty
     */
    public T dequeue();
    
    
    
    
    /**
     * Preconditions: 
     * 
     * 
     * Post conditions:
     * 
     * 
     * @return 
     */
    public T peek();
    
    
    
    /**
     * Preconditions: 
     * 
     * 
     * Post conditions:
     * 
     * 
     * @param t
     * @return 
     */
    public boolean checkQueue(T t);
    
    /**
     * Preconditions: 
     * 
     * 
     * Post conditions:
     * 
     * 
     * @return 
     */
    public boolean isEmpty();
    
    
}
