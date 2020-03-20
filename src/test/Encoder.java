package test;
/*
Problem 3: Encoder
        Create a program called Encoder. It takes a word as an input. The input word will contain only
        the uppercase alphabets(A to Z). The program should shift each char in the word by 5. i.e Print F
        in place of A, B -&gt; G, C -&gt; H....V -&gt; A W -&gt; B, X -&gt; C, Y -&gt; D, Z -&gt; E. 
        Example 1) 
        Input:  APPLE 
        Output: FUUQJ 
        Example 2) 
        Input: ZEBRA 
        Output: EJGWF
public class Encoder {
   private static final int SHIFT = 5;
   public String encode(String in) {
   }
}*/


public class Encoder {
    private static final int MAX_ASCII;
    private static final int START_ASCII;

    static {
        MAX_ASCII = 91;
        START_ASCII = 65;
    }

    public static void main(String[] args) {

        Encode encode = (String aString, int shiftBy) -> {
            StringBuilder givenString = new StringBuilder();
            int encodedAsci;
            String encodedString = "";
            for (char c : aString.toCharArray()) {
                encodedAsci = c + shiftBy;
                if (encodedAsci > MAX_ASCII) {
                    encodedAsci = encodedAsci % MAX_ASCII + START_ASCII;
                }
                encodedString = encodedString + Character.toString((char) encodedAsci);
            }
            return encodedString;

        };



/*
        Input:  APPLE 
        Output: FUUQJ 
        Example 2) 
        Input: ZEBRA 
        Output: EJGWF
                */
        System.out.println(encode.Encode("APPLE", 5));
        System.out.println(encode.Encode("ZEBRA", 5));



    }
}
