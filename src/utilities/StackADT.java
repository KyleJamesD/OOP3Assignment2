/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utilities;

/**
 *Class Definition: This Interface details a contract for a StackADT,The Stack must be able to Push (add) elements to the 
 * top of the stack, to pop  (remove) elements from the top of the stack, to peek at items in the stack
 * and check the stack to see if a element is located in the stack. 
 * 
 * 
 * @param <E> the type of elements held in the Stack
 * 
 * @author kyled
 */
public interface StackADT<E> {
    
    
    /**
     * Preconditions:
     * The Element to be pushed cannot not be null
     * 
     * 
     * Post conditions: 
     * Pushes the parameter element T to the top of the stack
     * 
     * @param t The Object to be pushed
     * @throws ElementIsNullException if null object is passed
     *  
     */
    public void push(E e);
    
    /**
     * Preconditions:
     * The stack must not be empty
     * 
     * 
     * Post conditions:
     * Removes the Top object from the stack and returns it. 
     * 
     * @return The Top object of the stack
     * @throws StackIsEmptyException if the stack is empty
     * 
     */
    public E  pop();
    
    /**
     * Preconditions:
     * The stack must not be empty
     * 
     * 
     * 
     * Post conditions:
     * will return the top most object from the stack without removing it. 
     * 
     * @return The top most object of the stack
     * @throws StackIsEmptyException if the stack is empty
     */
    public E peek ();
    
    /**
     * Preconditions:
     * The stack must not be empty
     * 
     * Post conditions:
     * returns true if the object is within the stack
     * 
     * 
     * 
     * @param t The object to check if it is in the stack
     * @return returns True if the object is in the stack otherwise returns false
     * @throws StackIsEmptyException if the stack is empty
     */
    public boolean checkStack(E e);
    
    
    
    /**
     * Preconditions:
     * None.
     * 
     * Post conditions:
     * Checks if the stack is empty
     * 
     * @return true if the stack is empty
     * @return false is the stack is not empty
     */
    public boolean isEmpty ();
       
}
