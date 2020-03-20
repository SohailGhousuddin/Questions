package Questions;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringFormatting {
    public static void main(String[] args) {
        ArrayList<String> stringsIn = new ArrayList<>();
        ArrayList<String> stringsOut = new ArrayList<String>();

        // Complete the following test using Java and return your working code.
        //Put your code in only this file.
        //Given a random alpha-numeric string with no special characters,
        //reformat the string without adding or removing any characters so that
        //no alphabet characters are adjacent to any other alphabet characters
        // and no numeric characters are adjacent to any other numeric characters,
        //if possible, and return the modified string. If it is not possible to
        //reformat the string in that way, then group all the alphabet characters at
        //the beginning of the string and all numeric characters at the end of the
        //string. In either case keep all alphabet characters in the same order relative
        //to each other before and after the formatting and also keep all numeric
        //characters in the same order releative to each other before and after the
        //formatting.

        // Example input1: "aabb12cc345"
        // Example output1: "a1a2b3b4c5c"
        // Example input2: "a1aa"
        // Example output2: "aaa1"


        stringsIn.add("aabb12cc345");
        stringsIn.add("a1aa");
        stringsIn.add("a1aa1");
        stringsIn.add("a1aa1b");
        stringsIn.add("111");
        stringsIn.add("aaa");


        stringsOut.add("a1a2b3b4c5c");
        stringsOut.add("aaa1");
        stringsOut.add("a1a1a");
        stringsOut.add("aaab11");
        stringsOut.add("111");
        stringsOut.add("aaa");




        int numCorrect = 0;

        for (int i = 0; i < stringsIn.size(); i++) {
            String result = reformatString(stringsIn.get(i));
            if (result.equals(stringsOut.get(i))) {
                numCorrect++;
            }
        }

        System.out.println("Correct: " + numCorrect + " out of total: " + stringsIn.size());

        return;
    }

    private static String reformatString(String str) {

        // Add your implementation here
        if (str == null || str.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        LinkedList<Character> alphabetic = new LinkedList<>();
        LinkedList<Character> numeric = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                alphabetic.add(str.charAt(i));
            } else numeric.add(str.charAt(i));
        }

        if (Math.abs(alphabetic.size() - numeric.size()) > 1) {
            while (!alphabetic.isEmpty()) {
                sb.append(alphabetic.pollFirst());
            }

            while (!numeric.isEmpty()) {
                sb.append(numeric.pollFirst());
            }

            return sb.toString();
        }

        if (alphabetic.size() >= numeric.size()) {
            while (!alphabetic.isEmpty()) {
                sb.append(alphabetic.pollFirst());
                sb.append(numeric.pollFirst());
            }
        }

        else {
            while (!numeric.isEmpty()) {
                sb.append(numeric.pollFirst());
                sb.append(alphabetic.pollFirst());
            }
        }
        sb.setLength(str.length());
        return sb.toString();
    }
}
