package Questions;

import java.util.ArrayList;

/*
Logic us use mod operator , select k greater than max element of array
arr[i]%k -- go to this index and add k to the content of arr[i]%k
this will make sure, we preserve the value of arr[i]%k, since it will give the same element
ex 3%4= 3 and after adding 3 it becomes 7 and 7%4 = 3 , next time it will be become 11
since same elements will come to this value and adding 7 will increase th value
now if we divide this by k, we can tell how many times this was added
so all elements which divides more then 1, ex 11/4 = 2 -- this means we have this element twice
 */
public class duplicateItemsArray {
    public static void main(String[] args)
    {
        int nums[] = {1,2,3,4,5,6,6,7,7,8};
        System.out.println(duplicateElement(nums,9));
    }
    public static ArrayList duplicateElement(int[] nums, int k)
    {
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        nums[nums[i]%k] =nums[nums[i]%k]+k;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]/k>1) result.add(nums[i]%k);
        }

        return result;
    }
}
