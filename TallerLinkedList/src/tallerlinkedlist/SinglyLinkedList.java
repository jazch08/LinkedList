package tallerlinkedlist;

public class SinglyLinkedList <E> {
    
    //Clase Node
    public static class Node <E>{
        private E element;
        private Node<E> next;
        
        public Node(E e, Node<E> n){
            element = e;
            next=n;
        }
        
        public E getElement(){
            return element;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setNext(Node<E> n){
            next=n;
        }
    }
    //Fin clase Node
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList(){};
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0){
            tail = null;
        }
        return answer;
                
    }
    
}
