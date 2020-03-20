package Questions;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.*;

public class XKindDeck {

    public static void main(String[] args)
    {
        //int[] deck = {1,1,2,2,2,3,3,4,2,3,4,4,4,3,3,3};
        //int[] deck = {1,2,3,4,4,3,2,1};
        //int[] deck = {1,1,1,2,2,2,3,3};
        //int[] deck = {1};
        int[] deck = {1,1,1,1,2,2,2,2,2,2,3,3,3};
        System.out.println( hasGroupsSizeX(deck));
    }

    static public boolean hasGroupsSizeX(int[] deck)
    {
        HashMap<Integer,Integer> dcCount = new HashMap<>();
        for (int a: deck ) {
            if(dcCount.containsKey(a)) {
                dcCount.put(a,dcCount.get(a)+1);
            }
            else  {
                dcCount.put(a,1);
            }
        }
       // System.out.println(dcCount);

       LCD(dcCount);

        System.out.println(LCD(dcCount));
        return true;
    }

    static public int LCD(HashMap ar)
    {
        Object[] a = ar.values().toArray();
        ArrayList<Integer> al = new ArrayList<>();
        for (int j=0;j<a.length;j++)
        {
            al.add((Integer)a[j]);
        }
        Collections.sort(al);
        if(al.get(0)==1) return 1;
        int least_val =  al.get(0);
        int l = 0;
        for(int k=2;k<least_val;k++)
        {
            for( l =1;l<al.size();l++)
            {
                if(al.get(l)%k!=0) {
                    System.out.println(al.get(l));
                l=l-1;
                    break;
                }
                System.out.println(l);

            }
            System.out.println(al.size());
            if(l==al.size()) return k;
            else return 1;
        }

        return 2;
    }

}
