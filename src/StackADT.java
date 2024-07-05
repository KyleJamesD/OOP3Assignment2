

/**
 * The StackADT interface is designed to be used for a linear last-in-first-out (LIFO) sequence of
 * elements where elements can only be added and removed at one end
 * (i.e. the top of the stack)
 *
 * @param <E> The type of elements this list holds.
 */
public interface StackADT<E>{
    /**
     * Add an element to the top of a stack
     *
     * @param e: the element to be added to the top of stack
     */
    public void push(E e);

    /**
     * Remove the topmost element from a stack
     *
     * @return the removed element
     */
    public E pop();

    /**
     * Access the topmost element in a stack without removing it
     *
     * @return the element on top of the stack
     */
    public E peek();

    /**
     * Returns true if this stack contains no elements
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack
     *
     * @return the number of elements in this stack
     */
    public int size();

    /**
     * Removes all the elements from this stack. The stack will be empty after this call returns.
     */
    void clear();
    /**
     * Returns true if this stack contains the same elements as the other stack(in same order)
     *
     * @param otherStack the stack to compare to
     * @return true if the stacks are equal
     */
    public boolean equals(StackADT<E> otherStack);

    /**
     * Returns an array containing all the elements in this stack in proper sequence
     *
     * @return an array containing all the elements in this stack in proper sequence
     */
    E[] toArray();

    /**
     * Returns the index of the first occurrence of the specified element in this stack, or -1 if this stack does not
     * contain the element. the top of the stack is considered to be at index 1, the next element is at index 2, and so on.
     *
     * @param e the element to search for
     * @return the index of the first occurrence of the specified element in this stack, or -1 if this stack does not
     * contain the element
     */
    int search(E e);


}
