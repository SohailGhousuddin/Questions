package Questions;

public class BackSpaceString {
    public static void main(String[] args)
    {
       // String S = "#ab#c";  output should be ac
        //String T = "ad#c"; output should be ac -- # means backspace so remove last char

         String S = "#a";
        String T = "a#a";

        System.out.println(backspaceCompare(S,T));
    }
    public static boolean backspaceCompare(String S, String T) {


      boolean result = actualString(S).equals(actualString(T)) ?  true:  false;
      return result;
    }

    public static String actualString(String S) {
       String sb = "";
        for(Character c:S.toCharArray())
        {
            // if the char is not # append , else sb > 0 truncate else copy sb as is
            sb=(c!='#')?sb+c:(sb.length()>0)?sb.substring(0,sb.length()-1):sb;

        }
    return sb;
    }
}
