import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {


        PriorityQueue<Integer> j = new PriorityQueue<>();
        j.offer(2);
        j.offer(3);
        j.remove(3);
        j.offer(5);
        j.offer(3);
        j.offer(3);
        // j.add(2);
        System.out.println(j);
        System.out.println(j.peek());
        System.out.println(j);
        System.out.println(j.poll());
        System.out.println(j);
        for(Integer i:j)
        {
            System.out.println(i);
        }

    }
}
