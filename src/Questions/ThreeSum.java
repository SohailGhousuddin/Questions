package Questions;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class ThreeSum {
    public static void main(String[] args)
    {
      // int[] nums =  {-1,0,1};
      //  int[] nums =  {-1,0,1,2,-2};
       // int[] nums = {-1,0,1,2,-1,-4};
       // int[] nums =  { -1, 0, 1, 2, -1, -4};
      //  int[] nums =  {-4,-2,2,-2,0,1,2,2,2,3,3,4,4,6,6};
        // -4,-2,-2,0,1,2,2,2,2,3,3,4,4,6,6
        // -4,-2,6 |-4,0,4|-4,1,3|-4,2,2| -2,-2,4|-2,0,2
       //  int[] nums =  {-4,-2,2,-2,0,1,2,2,2,-3,3,4,4,6,6};
      // int[] nums = {0,0,0};
        int[] nums ={1,2,-2,-1};
        //System.out.println(threeSum(nums));
        //System.out.println(theeSum(nums));
        System.out.println(Sum3(nums));
    }

    public static  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumber = new ArrayList<>();

            for(int i =0;i<nums.length;i++)
            {
                int left = i+1;
                int right = nums.length-1;
                if(!firstNumbers.contains(nums[i])) {
                    firstNumbers.add(nums[i]);
                    secondNumber.clear();
                    while (left <= nums.length - 2) {



                        secondNumber.add(nums[left]);
                            if (left == right) {
                                left=left+1;
                               if(secondNumber.contains(nums[left])) {

                                   left = left + 1;
                               }
                                right = nums.length - 1;
                            }
                            if (left < right && nums[left] + nums[right] + nums[i] == 0) {
                                List<Integer> r1 = new ArrayList<>();
                                r1.add(nums[i]);
                                r1.add(nums[left]);
                                r1.add(nums[right]);
                                if (!checkResult(r1, res)) res.add(r1);
                                right = right - 1;
                            } else {
                                right = right - 1;
                            }


                        }
                    }
                }

            return res;
    }
    public static boolean checkResult(List<Integer> r1,List<List<Integer>> res)
    {


        HashSet<Integer> op1 = new HashSet<>();
        HashSet<Integer> op2 = new HashSet<>();
        op1.add(r1.get(0));
        op1.add(r1.get(1));
        op1.add(r1.get(2));

        for(List<Integer> i:res)
        {
            op2.add(i.get(0));
            op2.add(i.get(1));
            op2.add(i.get(2));
            if(op1.equals(op2))
            {
                op2.clear();
                return true;
            }
            op2.clear();
        }
        return false;
    }
    public static boolean chRes(List<Integer> r1, List<List<Integer>> res)
    {
         Comparator<Integer> c =  new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer.compareTo(t1);
                }
            };
            r1.sort(c);
            for(List<Integer> i:res)
            {
                i.sort(c);
                return i.equals(r1)?true:false;
            }
            return false;

        }

    public static  List<List<Integer>> theeSum(int[] nums) {
        System.out.println("From new func");
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstNumbers = new ArrayList<>();
        List<Integer> secondNumber = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) { // rea first number
            int left = i+1;
            int right = nums.length-1;
            secondNumber.clear();
            if (!firstNumbers.contains(nums[i]))
            {
            while(left<nums.length-1) {
               if(secondNumber.contains(nums[left])) {
                  left=left+1;
                  continue;
               }
                     // see if the have already processed the first number, second number

                    secondNumber.add(nums[left]);
                    int i1 = Arrays.binarySearch(nums, left+1, nums.length, -(nums[i] + nums[left]));
                    if(i1>0) {

                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[left]);
                        a.add(nums[i1]);
                        if (!chRes(a, res)) res.add(a);


                    }
                    left=left+1;
                }
                firstNumbers.add(nums[i]);
            }

        }
        return res;
    }

    public static  List<List<Integer>> Sum3(int[] nums)
    {
        // we will sort the array
        // we use three pointers
        // i will be at first element
        // j will be immediate next element
        // k we will start from end
        // since the elements will be stored in ascending order
        // we need to check K only till sum is > 0
        // and add if sum = 0 to list
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp ;
        Arrays.sort(nums);
        Comparator<List<Integer>> c = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {

                return 0;
            }
        };
        HashSet<List<Integer>> hl = new HashSet((Collection) c);

        int k = 0;
        int i=0;
        int j = 0;
        int sum = 0;
        while(i<nums.length-2)
        {

         if((i>0) &&(nums[i]==nums[i-1])) {
                i=i+1;
                continue;
            }

            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j=j+1;
                    k=nums.length-1;
                    continue;
                }
                if(sum>0){
                    k=k-1;
                }
                if(sum<0) {
                   break;
                }

            }

                i++;
            }

        return res;
    }

}
