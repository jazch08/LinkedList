package tallerlinkedlist;

public class TallerLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        //l[como,h,o]
        
        
        l.addFirst("Como");
        l.addLast("o");
        System.out.println(l);
        l.add(0, "h");
        System.out.println("Size: "+l.size());
        
        System.out.println(l);
        System.out.println(l.size()+"   "+l.removeLast());
        System.out.println(l.size()+"   "+l.removeLast());
        //System.out.println(l.size()+"   "+l.removeLast());
        System.out.println(l);
        
    }
    
    
    
}
