package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseCharArray {
    public static void main(String[] args) {

        char[] s = {'a','b','c','d'};

       System.out.println(reverseString(s));
    }

        public static char[] reverseString(char[] s) {

        // Logic: take left to point to first char and right to point to last  char
        //  swap first and last char
        // increase left and decrease right till left crosses right
        // call swap function recursively
        int left = 0;
        int right= s.length-1;
        while(left<right)
        {
            swap(s,left,right);
            left++;right--;
        }
        return s;
    }
    public static void swap(char[] s, int a, int b)
    {
        char temp=s[a];
        s[a]=s[b];
        s[b]=temp;
        //return s;

    }
}
