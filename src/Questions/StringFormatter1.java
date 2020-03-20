package Questions;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class StringFormatter1 {


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
        stringsIn.add("a1111aa");
        stringsIn.add("a1111aaa");


        stringsOut.add("a1a2b3b4c5c");
        stringsOut.add("aaa1");
        stringsOut.add("a1a1a");
        stringsOut.add("aaab11");
        stringsOut.add("111");
        stringsOut.add("aaa");
        stringsOut.add("1a1a1a1");
        stringsOut.add("a1a1a1a1");



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
        int letterCount = numberOfAlphabet(str);
        int numberOfDigits = numberOfDigits(str);

        final String output;

        if (Math.abs(letterCount - numberOfDigits) <= 1) {
            output = formatAlternateChar(str);
        } else {
            output = formatLettersFirst(str, numberOfDigits);
        }

        return output;
    }

    private static String formatLettersFirst(String str, int digitsCount) {
        final int length = str.length();
        char[] out = new char[length];

        int letterIndex = 0;
        int digitIndex = length - digitsCount;

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                out[letterIndex] = ch;
                letterIndex++;
            } else {
                out[digitIndex] = ch;
                digitIndex++;
            }
        }
        return new String(out);
    }

    private static String formatAlternateChar(String str) {
        final int length = str.length();
        char[] out = new char[length];
        char[] input = str.toCharArray();

        final char firstChar = input[0];
        boolean letterAtStart = Character.isLetter(firstChar);

        int letterIndex = letterAtStart ? 0 : 1;
        int digitIndex = letterAtStart ? 1 : 0;

        for (int i = 0; i < length; i++) {
            final int insertAtIndex;
            final char currentChar = input[i];

            if (Character.isLetter(currentChar)) {
                insertAtIndex = letterIndex;
                letterIndex = letterIndex + 2;
            } else {
                insertAtIndex = digitIndex;
                digitIndex = digitIndex + 2;
            }

            out[insertAtIndex] = currentChar;
        }

        return new String(out);

    }

    public static int numberOfAlphabet(String str) {
        int count = 0;
        for (char alphabet : str.toCharArray()) {
            if (Character.isLetter(alphabet)) {
                count++;
            }
        }
        return count;
    }

    public static int numberOfDigits(String str) {
        int count = 0;
        for (char letter : str.toCharArray()) {
            if (Character.isDigit(letter)) {
                count++;
            }
        }
        return count;

    }

}