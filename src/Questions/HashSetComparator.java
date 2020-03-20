package Questions;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class HashSetComparator {
    public static void main(String[] args)
    {
        HashSet<Integer> i = new HashSet<>();
        i.add(2);
        i.add(3);
        i.add(2);

        System.out.println(i);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return -integer.compareTo(t1);
            }
        };
        PriorityQueue<Integer> j = new PriorityQueue<>(c);
        j.offer(2);
        j.offer(3);
        j.remove(3);
        j.offer(5);
        j.offer(3);
        j.offer(3);
       // j.add(2);
        System.out.println(j);
    }
}
