import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    ArrayList<String> stringsIn = new ArrayList<String>();
    ArrayList<String> stringsOut = new ArrayList<String>();
    
    // Complete the following test using Java and return your working code. Put your code in only this file. Given a random alpha-numeric string with no special characters, reformat the string without adding or removing any characters so that no alphabet characters are adjacent to any other alphabet characters and no numeric characters are adjacent to any other numeric characters, if possible, and return the modified string. If it is not possible to reformat the string in that way, then group all the alphabet characters at the beginning of the string and all numeric characters at the end of the string. In either case keep all alphabet characters in the same order relative to each other before and after the formatting and also keep all numeric characters in the same order releative to each other before and after the formatting.
    
    // Example input1: "aabb12cc345"
    // Example output1: "a1a2b3b4c5c"
    // Example input2: "a1aa"
    // Example output2: "aaa1"
     
    stringsIn.add("aabb12cc345");
    stringsIn.add("a1aa");
    
    stringsOut.add("a1a2b3b4c5c");
    stringsOut.add("aaa1");
    
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
  
  /**
	 * @param str
	 * @return reformatString
	 * 
	 * This method takes string as input, rearrange and returns reformatted string
	 */
	private static String reformatString(String str) {

		Queue<Integer> alphabetIndices = new LinkedList<>();

		Queue<Integer> numIndices = new LinkedList<>();

		// seperating alphabets and numbers
		for (int i = 0; i < str.length(); i++) { 
			if (Character.isDigit(str.charAt(i))) {
				numIndices.add(i);
			} else {
				alphabetIndices.add(i);
			}
		}

		// edge case scenario where there might be only alphabets or only numbers in given string or string lenght is 2 
		if (numIndices.size() == 0 || alphabetIndices.size() == 0 || str.length() == 2) {
			return str;
		}

		// logic for reformatting string
		// if difference between alphabets length and numbers length > 1 put all alphabets at the start and numbers at the end
		// else we can arrange them with alternate letter and integer
		if (numIndices.size() == alphabetIndices.size() || alphabetIndices.size() == numIndices.size() - 1) {
			return getReformatedAlternateString(numIndices, alphabetIndices, str);
		} else if (numIndices.size() == alphabetIndices.size() - 1) {
			return getReformatedAlternateString(alphabetIndices, numIndices, str);
		} else {
			return getReformatedOrderedString(alphabetIndices, numIndices, str);
		}
	}

	/**
	 * @param indices1
	 * @param indices2
	 * @param rootString
	 * @return formatedString
	 * 
	 * This method will reformat the string with alternate alphabets and digits
	 */
	private static String getReformatedAlternateString(Queue<Integer> indices1, Queue<Integer> indices2,
			String rootString) {
		StringBuilder formattedString = new StringBuilder();
		for (int i = 0; i < rootString.length(); i++) {
			if (i % 2 == 0) {
				formattedString.append(rootString.charAt(indices1.poll()));
			} else {
				formattedString.append(rootString.charAt(indices2.poll()));
			}
		}
		return formattedString.toString();

	}

	/**
	 * @param alphabetIndices
	 * @param numIndices
	 * @param rootString
	 * @return formatedString
	 * 
	 * This method arrange all the alphabets at starting of the String and numbers at end of the string
	 */
	private static String getReformatedOrderedString(Queue<Integer> alphabetIndices, Queue<Integer> numIndices, String rootString) {
		StringBuilder formattedString = new StringBuilder();
		while(alphabetIndices.peek() != null) {
			formattedString.append(rootString.charAt(alphabetIndices.poll()));
		}
		while(numIndices.peek() != null) {
			formattedString.append(rootString.charAt(numIndices.poll()));
		}
		return formattedString.toString();
	}
}
