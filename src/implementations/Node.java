/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

/**
 *
 * @author kyled
 */

public class Node<E> {
    
    E value;
    Node<E> next;
    Node<E> previous;

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next, Node<E> previous) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

   
    
    
    
    
}
