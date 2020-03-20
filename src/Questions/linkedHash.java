package Questions;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class linkedHash {
    public static void main(String[] args)
    {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(5);
        lhs.add(20);
        System.out.println(lhs);
        //lhs.remove(lhs.)

        IdentityHashMap<Integer,Integer> ihm = new IdentityHashMap<>();
        ihm.put(null,10);
        ihm.put(null,20);
        System.out.println(ihm);
        LinkedList<Integer> Q = new LinkedList<>();
        Q.offer(10);
        Q.offer(30);
        Q.offer(56);
        Q.offer(5);
        System.out.println(Q.poll());
        System.out.println(Q.peek());
        System.out.println(Q);

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return 0;
            }
        };

    }

}
