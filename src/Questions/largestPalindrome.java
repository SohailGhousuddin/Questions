package Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class largestPalindrome {
    public static void main(String[] args)
    {
        String s = "abcabacdcbaabc";
        System.out.println("res: "+palindrome(s));
    }
    public static String palindrome(String s)
    {
        String res1 = "";
        StringBuilder res2= new StringBuilder();
        PriorityQueue<String> e = new PriorityQueue<>();
        Comparator cp = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return -o.toString().compareTo(t1.toString()) ;
            }
        };
        PriorityQueue<String> listofPalindromes = new PriorityQueue<>(cp);

        char[] c = s.toCharArray();
        int start=-1;
        int end = -1;
        for(int i=0;i<c.length-1;i++) {
            start = i;
            end = c.length-1;
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
                    res2=res2.length()>0?res2.length()==1?res2.deleteCharAt(0):res2.delete(0,res2.length()-1):res2;


                }

            }
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
