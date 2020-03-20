package Questions;

import java.util.*;
import java.util.concurrent.Callable;

public class temp {

    public class cll implements Callable {
        public Object call()
        {
            return -1;
        }
    };


    public static void main(String[] args)
    {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return -integer.compareTo(t1);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(c);
        ts.add(10);
        ts.add(20);
        ts.add(50);
        ts.add(40);
        ts.add(30);
        ts.add(10);
        System.out.println(ts);
        ts.add(ts.pollFirst());
        System.out.println(ts);
        System.out.println(ts.first());
        SortedSet<Integer> hs  = ts.tailSet(30,false);
        SortedSet<Integer> hst = ts.headSet(20,true);

        NavigableSet<Integer> ns =ts.subSet(40,true,20,true);
        System.out.println(ns);


        TreeMap<Integer,Integer> tm = new TreeMap<>();


        Iterator<Integer> i = hs.iterator();
        Iterator<Integer> t = hst.iterator();
        LinkedHashSet<Integer> lhs= new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(20);
        lhs.add(50);
        lhs.add(40);
        lhs.add(30);
        lhs.add(10);

        Iterator<Integer> ilhs=lhs.iterator();
       // ilhs.


        while(i.hasNext())
        {
            Integer temp = i.next();
            System.out.println(temp);
          //  i.remove();

            //if(temp==30) ts.remove(30);


        }
      //  ts.remove(30);
        System.out.println(ts);
        while(t.hasNext())
        {
            System.out.println(t.next());
        }

    }
}
