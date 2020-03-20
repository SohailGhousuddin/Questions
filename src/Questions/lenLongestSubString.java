package Questions;

import java.util.LinkedList;
import java.util.List;

public class lenLongestSubString {
    public static void main(String[] args)
    {
        String s ="abcdefabcdefghababab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength=0;

        List<Character> l;
        LinkedList<Character> list = new LinkedList<Character>();
        // here we are trying find the longest substring till we get repetitive char
        // for list is what we star adding the chars
        // once we see repetitive char
        // we try to add to list if the size is max size
        // copy rest of the list and start again
        for(char c:s.toCharArray())
        {
            if(list.contains(c))
            {
                list.lastIndexOf(c);
               l=list.subList(list.indexOf(c)+1,list.size());
                maxLength=list.size()>maxLength?list.size():maxLength;
               list = new LinkedList<Character>(l);
               list.add(c);

            }
            else {
            list.add(c);

            }


        }
        maxLength=list.size()>maxLength?list.size():maxLength;
        return maxLength;
    }
}
