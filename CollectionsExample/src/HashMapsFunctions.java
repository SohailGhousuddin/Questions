import java.util.*;

public class HashMapsFunctions {
    public static void main(String[] args) {
        System.out.println("testing");
        HashMap<Double, Integer> hm = new HashMap<>();
        addItems(hm,12.0,12);
        addItems(hm,14.9,14);
        addItems(hm,15.9,15);
        addItems(hm,16.9,16);
        addItems(hm,17.9,17);
        addItems(hm,19.9,18);

        System.out.println(removeItem(hm,19.9));
        displayItem(hm);
        displayKeys(hm);
        displayValues(hm);


    }

    public static void addItems(HashMap h, Double d, Integer i) {
        h.put(d, i);
    }

    public static Integer removeItem(HashMap h, Double d) {
        return (Integer) h.get(d);
    }

    public static void displayItem(HashMap h)
    {
        System.out.println(h);

        Set s = h.entrySet();
        Iterator i = s.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        Iterator i1 = s.iterator();
        System.out.println("key value");
        while(i1.hasNext())
        {
            Map.Entry<Double,Integer> e = (Map.Entry)i1.next();
            System.out.println(e.getKey()+"::"+e.getValue());
        }

    }
    public static void displayKeys(HashMap h)
    {
        Set s = h.keySet();
        Iterator<Double> id = s.iterator();

        while(id.hasNext())
        {
            System.out.println(id.next());
        }

    }
    public static void displayValues(HashMap h)
    {
        Collection s = h.values();
        Iterator<Integer> is = s.iterator();
        while(is.hasNext())
        {
            System.out.println(is.next());
        }

    }
    public static boolean checkIfContainsKey(HashMap h, Double d)
    {
        return h.containsKey(d);
            }
    public static boolean checkIfContainsValue(HashMap h,Integer i)
    {
        return  h.containsValue(i);
    }
}
