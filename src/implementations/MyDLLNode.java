package src.implementations;

public class MyDLLNode<E> {

    E data;
    MyDLLNode<E> next;
    MyDLLNode<E> prev;

    public MyDLLNode(E data) {
        this.data = data;
        this.next = this.prev = null;
    }

    public MyDLLNode(E data, MyDLLNode<E> next) {
        this.data = data;
        this.next = next;
    }

}
