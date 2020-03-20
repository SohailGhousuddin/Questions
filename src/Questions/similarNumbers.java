package Questions;
/*
X of a Kind in a Deck of Cards

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.

Input: [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]

Input: [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Input: [1]
Output: false
Explanation: No possible partition.

Input: [1,1]
Output: true
Explanation: Possible partition [1,1]

Input: [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2]

1 <= deck.length <= 10000
0 <= deck[i] < 10000


solution 1: time complexity O(n) and space complexity O(n)
            1. take a map with key as deck[i] and value keep adding if we get the same number
            2. once map is created, loop through the map and see if all the values are even
               2.1 all even then return true
               2.2 at least one fails, return false


 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class similarNumbers {

       public static void main(String[] args)
    {

      int[] deck = {1,2,3,3,2,1};
      hasGroupsSizeX(deck);
    }
    public static  boolean hasGroupsSizeX(int[] deck)
    {
        boolean res = false;

        HashMap<Integer,Integer> hmap = new HashMap<>();


        for (int a: deck ) {
            if(hmap.containsKey(a))
            {
                hmap.replace(a,hmap.get(a)+1);
            }
            else {
                hmap.put(a,1);
            }

             Set set = hmap.entrySet();
            Iterator it = set.iterator();
            Map.Entry m;
            Integer count = 0;

            while(it.hasNext())
            {
                 m = (Map.Entry) it.next();
                count = (int)m.getValue();
            }

            }



        return res;
    }
}
