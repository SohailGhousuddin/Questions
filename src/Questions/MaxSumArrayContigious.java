package Questions;

import java.util.Arrays;
import java.util.HashMap;

public class MaxSumArrayContigious {
    public static void main(String[] args) {
        int[] nums = {-3,20,-5,-2,-5,-8,-1,10,1-10};
        System.out.println(maxSum(nums));

    }

    public static int maxSum(int[] nums) {
        int max_sum=nums[0],max_so_far=nums[0];
        for(int i=1;i<=nums.length-1;i++)
        {
            max_so_far=Math.max(nums[i],max_so_far+nums[i]);
            max_sum=Math.max(max_so_far,max_sum);
        }

        System.out.println("Stream without terminal operation");

        Arrays.stream(new int[] {1,2,3}).map(i-> {
            System.out.println("doubling"+i);
            return i=2;

        });
        System.out.println("Stream with terminal operation");
        Arrays.stream(new int[] {1,2,3}).map(i->{
            System.out.println("doubling"+i);
            return i * 2;
        }).sum();

        HashMap <String, Integer> hm = new HashMap<>();
        hm.put("A",1);
        hm.put("A",2);
        int arr[] ={1,2};
        int arr1[] = {1,2};
        if(arr==arr1)
        {
            System.out.println("true");
        }

        return max_sum;
    }
}

