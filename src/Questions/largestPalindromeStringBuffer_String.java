package Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class largestPalindromeStringBuffer_String {
    public static void main(String[] args)
    {
        String s = "abcabacdcbaabc";
        System.out.println("res: "+palindrome(s));
    }
    public static String palindrome(String s)
    {
        String res1 = "";
        StringBuilder res2= new StringBuilder();
        Comparator cp = new Comparator() {
            @Override
            // we are comparing the strings which is biggest we will put it at the top
            // default order is ascending so we are making to descending
            public int compare(Object o, Object t1) {
                return -o.toString().compareTo(t1.toString()) ;
            }
        };
        // we use priority que to always have the longest palindrome at the top
        PriorityQueue<String> listofPalindromes = new PriorityQueue<>(cp);

        char[] c = s.toCharArray();
        int start=-1;
        int end = -1;
        // for loop to look for each character, if we did not found similar character from endside
        // then we will increase start position
        for(int i=0;i<c.length-1;i++) {
            start = i;
            end = c.length-1;
            // we see if we have a palindrome here by using two pointers
            // left and right at the end we will have two halfs of palindrome
            while (start<end)
            {
                if(c[start]==c[end]) {
                    res1=res1+c[start];
                    res2=res2.append(c[end]);
                    start++;end--;
                }else{
                    end=end-1;
                    start=i;
                    res1="";
                    // String buffer does not have delete all so we are deleting each char
                    res2=res2.length()>0?res2.length()==1?res2.deleteCharAt(0):res2.delete(0,res2.length()-1):res2;
                    //res2=;

                }

            }
            // here we are at the center so add the char only once
            // abcba -- here start and end is at c , so we need to add only once
            // the we are reversing the second and getting the actual palindrome
            if(start==end&&res1.length()>1) {
                res1=res1+c[start];
                res2=res2.reverse();
               // return res1+res2;
                System.out.println(res1+res2);

                listofPalindromes.offer(res1+res2);
                res1="";
                res2=res2.delete(0,res2.length()-1);
            }
            if(end<start&&res1.length()>1) {
                res2=res2.reverse();
                listofPalindromes.offer(res1+res2);
                System.out.println(res1+res2);
                res1="";
                res2=res2.delete(0,res2.length()-1);

               // return res1+res2;
            }


        }
        return listofPalindromes.peek();

    }
}
