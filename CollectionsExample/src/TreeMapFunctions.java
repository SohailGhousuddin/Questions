import java.util.*;

public class TreeMapFunctions {
    public static void main(String[] args) {

        TreeMap tm =new TreeMap();
        tm.put("One",1);
        tm.put("Two",2);
        tm.put("Two",3);

        System.out.println(tm.remove("Three"));
        System.out.println(tm);

        Set sm = tm.entrySet();
        Iterator i = sm.iterator();
        System.out.println(tm.containsKey("One"));

        while(i.hasNext())
        {
            Map.Entry<String,Integer> e = (Map.Entry) i.next();
            System.out.println(e.getKey());
            System.out.println(e.getValue());

        }


        }
    }

