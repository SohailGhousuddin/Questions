package Questions;

/*import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;
*/
import java.util.*;

public class KthLargestNumber {
    public static void main(String[] args)
    {
        //int[] nums = {1,1,1,1,1,1,1,1,1};
       // int[] nums = {9,3,5,8,9,11,17,30,999,12345};
       // int[] nums = {3,2,1,5,6,4};
        int[] nums = {3,2,3,1,2,4,5,5,6};


        System.out.println(kLargest(nums,4));
        System.out.println(kLargestSort(nums,4));
        System.out.println(KLargestTree(nums,4));
    }
    public static int kLargest(int[] nums, int k)
    {
        /*
        option 1: put the number in priority Q (if numbers are unique) and loop to get the kth largest number time O(n(log(n)), space O(n)
        option 2: Sort the array and loop to find the kth unique number -- space O(1), time O(nLog(n))
        option 3: create an BTree ( if numbers are repeated) and iterate - time - O(n(log(n)) space O(n)
         */
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        for (int i:nums)
        {
         pq.offer(i);
        }
        if(pq.size()<k) return -1;
        while(k>1)
        {
           pq.poll();
            k--;
        }

        if(k==1)  return pq.peek();
        return -1;
    }

    public  static int kLargestSort(int[] nums,int k)
    {
        Arrays.sort(nums);
        int i=nums.length-1;
        for(;i>1&&k>1;i--)
        {
            if(nums[i-1]!=nums[i]) k--;

        }
        if(k==1) return nums[i];
        return -1;
    }
    public static int KLargestTree(int[] nums,int k)
    {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(c);
        for(int i: nums)
        {
            ts.add(i);
        }
        Iterator<Integer> it = ts.iterator();
        int res = -1;
        while(k>1 &&it.hasNext())
        {
            res = it.next();
            k--;
        }
        if(k==1) return  it.next();
        return -1;
    }
}
