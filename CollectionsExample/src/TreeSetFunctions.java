import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class TreeSetFunctions {
    public static void main(String[] args) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {


                return o2.toString().compareTo(o1.toString()) ;
            }
        };
        TreeSet ts = new TreeSet(c);
    ts.add("One");
    ts.add("Two");
    ts.add("Three");
    ts.add(1);
    ts.add(19.0);
        System.out.println(ts);

        ts.remove("One");
        System.out.println( ts.contains("Two"));
        Iterator i =ts.iterator();



    }
}
