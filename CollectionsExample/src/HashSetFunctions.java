import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class HashSetFunctions {
    public static void main(String[] args) {
       // HashSet will not take comparator as argument
        HashSet hs = new HashSet<>();
        hs.add("One");
        hs.add("Two");
        hs.add("Three");
        hs.add("Thre");
        hs.add("Two");
        hs.add("Three");

        System.out.println(hs);
        hs.remove("Three");
        hs.removeIf(s -> s.equals("Two"));
        hs.add("Two");
        hs.add("Three");
        hs.add("Four");
        hs.add("Three");
        hs.add(1);
        hs.add(19.09);
        Iterator i = hs.iterator();
        for (Iterator it = i; it.hasNext(); ) {
           // String t = it.next().toString();
            Object o=it.next();
            System.out.println(o.getClass().getName());
            System.out.println(o);


        }
    }
}
