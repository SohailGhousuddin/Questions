package Questions;

import java.lang.reflect.Array;

public class ArrangeArrays {
    public static void main(String[] args) {
        int[] nums = {1, -1, 3, 2, -7, -5, 11, 6 };
        nums = ArrangeArr(nums);
        for (int i: nums
             ) {
            System.out.print(i+" ");
        }

    }

    public static int[] ArrangeArr(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j)
        {
            if(nums[i]<0)
            {
                while(nums[j]<0)
                {
                    j--;
                }
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;j--;

            }
            i++;
        }
        return nums;
    }
}
