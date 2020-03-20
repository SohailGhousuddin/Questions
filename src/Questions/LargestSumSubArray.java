package Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestSumSubArray {
    public static void main(String[] args)
    {
     int[] nums = {7,2,5,10,8};
        ArrayList<List<Integer>> resArray = new ArrayList<>();

     int m=2;
     splitArray(nums,m);
    }
    public static int splitArray(int[] nums, int m) {
          int nArrys=nums.length/m;
          int sum=0;
        for (int i: nums) {
            sum=sum+i;
        }
        System.out.println(nArrys);
        return 0;
    }
}
