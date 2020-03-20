package Questions;

public class contElemSum {
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,20,5,6,9,8,7};
        contElements(nums,11);

    }
    public static void contElements(int[] nums, int sum) {
        int countSum = 0;
        int i = 0;
        int left = 0,right=0;
        // find the first number which is less then sum
        // nums[i]/left will be always assigned to a value which is always less than sum
        for (; i < nums.length; i++) {
            if (nums[i] < sum) {
                countSum = nums[i];
                break;
            }

        }

        if(i>nums.length) {
            System.out.println("does not exist");
            return;
        }
        left = right =i;
        /*
         case 1: we have more elements to read, read each element and check if the total is less the sum, continue the loop
         case 2: total is > sum  so remove the first element or all the elements till total is less then  required sum
         */

        countSum = nums[i];
        while(right<nums.length) {
            right++;
            int len = nums.length;
            if(right<len) {
                countSum+=nums[right];
            }
            if(countSum>sum) {
                while(countSum>sum) {
                        countSum=countSum-nums[left];
                        left=left+1;
                }
            }
            if(countSum==sum) {
                System.out.println("Numbers are: " +left+" "+right);
                return;
            }

        }
        System.out.println("does not exist");
    }
}
