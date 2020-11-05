package tallerlinkedlist;

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
        if (size == 1) {
            E temp = tail.getElement();
            head = tail = null;
            size--;
            return temp;
        }
        Node<E> newtail = getPreviusNode(tail);
        E temp = tail.getElement();
        tail = newtail;
        size--;
        return temp;
    }

    private Node<E> getPreviusNode(Node<E> node) {
        if (size < 2) {
            return null;
        }
        Node<E> n0 = head;
        Node<E> n1 = head.getNext();
        while (n1.getNext() != null) {
            n0 = n1;
            n1 = n1.getNext();
            if (node.equals(n1)) {
                return n0;
            }
        }
        return null;
    }

    public E remove(int i) {
        if (i > size || i < 0) {
            return null;
        } else if (i == size - 1) {
            removeLast();
        } else if (i == 0) {
            removeFirst();
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
            //addLast();
            return true;
        } else if (index == 0) {
            //addFirst();
            return true;
        }
        int pos = 0;
        for (Node<E> e = head; e.getNext() != null; e = e.getNext()) {
            if (pos == index - 1) {
                Node<E> temp = e.getNext();
                Node<E> newNode = new Node(element, temp);
                e.setNext(newNode);
                return true;
            }
            pos++;
        }
        return false;
    }
}
