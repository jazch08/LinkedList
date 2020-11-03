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
    public int find(E element){
        Node n =head;
        if (n==null)return -1;
        int pos=0;
        while (n.getNext()!=null){
            if (n.getElement().equals(element))return pos;
            pos ++;
            n=n.getNext();
        }
        return -1;
    }
    public boolean contains (E element){
        return find(element)!=-1;
    }
    public E removeLast(){
        if(size==0)return null;
        if (size==1) {
            E temp= tail.getElement();
            head= tail=null;
            size--;
            return temp;
        }
        Node <E> newtail= getPreviusNode(tail);
        E temp = tail.getElement();
        tail=newtail;
        size --;
        return temp;
    }
    private Node<E> getPreviusNode(Node<E> node){
        if (size<2)return null;
        Node<E> n0=head;
        Node <E> n1=head.getNext();
        while (n1.getNext()!=null){
            n0=n1;
            n1=n1.getNext();
            if (node.equals(n1))return n0;
        }
        return null;
       
    }
}
