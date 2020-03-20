package Questions;

public class maxElementsArray {
    public static void main(String[] args)
    {
        int[] nums={2,3,2,10,10,10,10,8,8,8,10};
        System.out.println(maxElement(nums));
    }
    public static int maxElement(int[] arr)
    {
        int res = 0;
        int n = 10;
        int k = 11;

/*
PRECONDITION -- MAX ELEMENT SHOULD NOT BE GREATER THAN SIZE OF ARRAY
 Given an array of size n, the array contains numbers in range from 0 to k-1
 k <= n ; the max element of array should be less than or Equal to size of ARRAY
1. K should be always one greater than max element in array AND K CANNOT be GREATER than N- size of array,
   if we have 8 element as max then k = 8+1
        here the logic is if we do mod we will get the reminder use the reminder and add
        infact K should be greater than max element of arr[]
2. logic is K mod arr[i] will give you reminder and if we add K to arr[i] and do mod it will give the same result
   so  2 mod 9 = 2, so arr[2] = arr[2]+9 = arr[2] = 11
   every time we see 2 in arr[], arr[2] will get more 9, next time it will be 20, 29 .. so on

   so any number which is repeating more times, it will be summed up by k , and since K is one greater than
   max no, so there will not be a chance of missing anything or sum being less than actual number


*/
        for (int i = 0; i< n; i++)
            arr[(arr[i]%k)] += k;

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }


        return result;
    }
}
