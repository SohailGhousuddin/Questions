import java.util.Iterator;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.add("Test");
        s.add(1);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.remove(2));
        s.add(49);
        System.out.println(s);
        Iterator i = s.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
