import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExamples {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(1);
        l.addFirst(2);
        l.addLast(3);
        l.add(4);
        l.add(5);
        l.add("String");

        Iterator i = l.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        System.out.println(l);
    }
}
