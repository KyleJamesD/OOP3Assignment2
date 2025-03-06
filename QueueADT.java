package utilities;

/**
 * The QueueADT interface is designed to be used for a linear first-in-first-out (FIFO) sequence of
 * elements where elements can only be added at one end
 * (i.e. the tail) and removed at the other end (i.e. the head)
 * @param <E>
 */
public interface QueueADT<E> {

    /**
     * Adds an item to the rear of the queue.
     * @param e: the element to be added
     */
    public void enqueue(E e);

    /**
     * Removes an item from the front of the Queue and returns it.
     * @return the removed element
     */
    public E dequeue();

    /**
     * Removes all items in the queue leaving an empty queue.
     */
    public void clear();

    /**
     * Lookup the item at front of the Queue without removing it.
     * @return the item at front of the Queue without removing it.
     */
    public E peek();

    /**
     * Returns true if the Queue is empty.
     * @return true if the Queue is empty.
     */
    public boolean isEmpty();

    /**
     * Returns the number of items in the Queue.
     * @return the number of items in the Queue.
     */
    public int size();
}
