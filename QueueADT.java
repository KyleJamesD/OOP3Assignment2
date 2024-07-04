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
    public void dequeueAll();

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

    /**
     * Two queues must contain equal items appearing in the same order
     * @param that: the queues to be compared.
     * @return true if the queues are equal.
     */
    public boolean equal(QueueADT<E> that);

    /**
     * Returns an iterator over the items contained in this stack
     * @return an iterator over the items contained in this stack
     */
    public Iterator<E> iterator();

    /**
     * Return an array containing all the items in this queue
     * @return an array containing all the items in this queue
     */
    public Object[] toArray();

    /**
     * Return an array containing all the items in this queue
     * @param copy: an array
     * @return an array containing all the items in this queue
     */
    public E[] toArray(E[] copy);

    /**
     * optional method if the queue is fixed size
     * @return true if the queue is fixed size
     */
    public boolean isFull();

}
