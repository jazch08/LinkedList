package tallerlinkedlist;

import java.util.Objects;

public class SinglyLinkedList<E> {

    //Clase Node
    public static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node<?> other = (Node<?>) obj;
            if (!Objects.equals(this.element, other.element)) {
                return false;
            }
            if (!Objects.equals(this.next, other.next)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Node{" + "element=" + element + ", next=" + next + '}';
        }
        
        
    }
    //Fin clase Node

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    ;
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;

    }

    public int find(E element) { //index
        Node n = head;
        if (n == null) {
            return -1;
        }
        int pos = 0;
        while (n.getNext() != null) {
            if (n.getElement().equals(element)) {
                return pos;
            }
            pos++;
            n = n.getNext();
        }
        return -1;
    }

    public boolean contains(E element) {
        return find(element) != -1;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        if(size == 1) {
            E temp = tail.getElement();
            head = tail = null;
            size--;
            return temp;
        }
        Node<E> newtail = getPreviusNode(tail);//obtener el penultimo elemento
        E temp = tail.getElement();
        System.out.println(newtail+"returned");
        tail = newtail;
        tail.setNext(null);
        size--;
        return temp;
    }
    

    private Node<E> getPreviusNode(Node<E> node) {
        if (size < 2) {
            return null;
        }
        Node<E> current = head;
        while (current.getNext()!=null){
            if (current.getNext()==node)
                return current;
            current=current.getNext();
        }
       
        return null;
    }

    public E remove(int i) {
        if (i > size || i < 0) {
            return null;
        } else if (i == size - 1) {
            return removeLast();
        } else if (i == 0) {
            return removeFirst();
        }
        int pos = 0;
        for (Node<E> e = head; e.getNext() != null; e = e.getNext()) {
            if (pos == i - 1) {
                Node<E> temp = e.getNext().getNext();
                e.setNext(temp);
                size--;
                return e.getNext().getElement();
            }
            pos++;
        }
        return null;
    }

    public boolean add(int index, E element) {
        if (index > size || index < 0) {
            return false;
        } else if (index == size) {
            addLast(element);
            return true;
        } else if (index == 0) {
            addFirst(element);
            return true;
        }
        int pos = 0;
        for (Node<E> e = head; e.getNext() != null; e = e.getNext()) {
            if (pos == index - 1) {
                size++;
                Node<E> temp = e.getNext();
                Node<E> newNode = new Node(element, temp);
                e.setNext(newNode);
                return true;
            }
            pos++;
        }
        return false;
    }  
    
    public void addLast(E element){   
        Node<E> newest= new Node<>(element,null);  
        if(isEmpty()){
            head=newest;
        }else{
            tail.setNext(newest); 
            tail=newest;
            size++;  
        }
    }
    
    public void addFirst(E element){
        head=new Node<>(element,head);
        if(size==0){
            tail=head;
        }
        size++;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" + "head=" + head + ", tail=" + tail + ", size=" + size + '}';
    }
    
    
    
}
