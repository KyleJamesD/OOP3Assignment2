package utilities;


/**
 * The StackADT interface is designed to be used for a linear last-in-first-out (LIFO) sequence of
 * elements where elements can only be added and removed at one end
 * (i.e. the top of the stack)
 * @param <E> The type of elements this list holds.
 */
public interface StackADT<E> {
    /**
     * Add an element to the top of a stack
     * @param e: the element to be added to the top of stack
     */
    public void push(E e);

    /**
     * Remove the topmost element from a stack
     * @return the removed element
     */
    public E pop();

    /**
     * Access the topmost element in a stack without removing it
     * @return the element on top of the stack
     */
    public E peek();

    /**
     * Returns true if this stack contains no elements
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack
     * @return the number of elements in this stack
     */
    public int size();

    /**
     * Two stacks must contain equal items appearing in the same order
     * @param that: the stack to be compared.
     * @return true if the stacks are equal.
     */
    public boolean equal(StackADT<E> that);

    /**
     * Returns an iterator over the items contained in this stack
     * @return an iterator over the items contained in this stack
     */
    public Iterator<E> iterator();

    /**
     * Return an array containing all the items in this stack
     * @return an array containing all the items in this stack
     */
    public Object[] toArray();

    /**
     * Return an array containing all the items in this stack
     * @param copy: an array
     * @return an array containing all the items in this stack
     */
    public E[] toArray(E[] copy);

    /**
     * Search an object
     * @param obj: the object to be searched
     * @return the index of the object
     */
    public int search(E obj);

    /**
     * Check the object if it is contained in the array
     * @param obj: the object to be searched
     * @return true if the object contains in the array
     */
    public boolean contains(E obj);
}
