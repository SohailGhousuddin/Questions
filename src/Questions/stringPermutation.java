package Questions;

import java.util.HashSet;
import java.util.Vector;

public class stringPermutation {
    public static void main(String[] args)
    {
        HashSet<String> v = new HashSet<>();
        String s="ABC";
        int n = s.length()-1;
        permute(v,s,0,n);
        System.out.println(v);

    }
    public static void permute(HashSet<String> res,String input,int l,int r)
    {
         if(l==r)
         {
             res.add(input);
             System.out.println(input);
         }
         else {
             for(int i=l;i<=r;i++) {
                 input = swap(input,l,i);
                 permute(res,input,l+1,r);
                 swap(input,i,l);
             }
         }



    }
    public static String swap(String input,int l, int r)
    {

        char[] i = input.toCharArray();
        char temp =i[l];
        i[l]=i[r];
        i[r]=temp;
        return String.valueOf(i);
    }
}
