import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueFunctions {
    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.offer(20);
        q.offer("String");
        q.add(30);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.contains("String"));
        Iterator i = q.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

    }
}
