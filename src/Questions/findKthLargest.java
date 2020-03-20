package Questions;

import java.util.Arrays;

public class findKthLargest {

    public static void main(String[] args)
    {
        // here  we will sort the array and see if there are any repetitions then
        // ignore them
        int[] nums = {3,2,3,1,2,4,5,5,6};
        //           {1,2,2,3,3,4,5,5,6}
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int pos = 1;

        if(k==1)
            return nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]!=nums[i-1]) pos++;
            if(pos==k) return nums[i-1];
        }
        return -1;

    }
}
