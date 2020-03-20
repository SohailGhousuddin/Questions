public class Test {

    /*
    Given a mixed string, put all lowercase characters first,
     followed by uppercase, followed by rest ..
    Input: "1HellOWorLd#"
    Output: "ellordHOWL1#"
    order does not matter
     */

    /*
    Sol 1: I can use three arrays
           1. Lower case
           2. upper case
           3. rest
           for each char read and put in each individual array accordingly
           at the end do append
           time complexity O(n) , Space O(n)

     Sol 2: Time complexity O(n), space O(1)
          use the same array
          1. read char
              if it is rest , push to end
              so at the end of first loop all rest will be at the end
              2. read the array again
                 this time use two pointers, 0 and last index before rest
                 now swap caps to last index

     */
    public static void main(String[] args) {
        System.out.println("Testing");
       String input = "1HellOWorLd#";
       // String input = "1HellO5W3or3Ld3#";
        System.out.println(input);
        System.out.println(formatString(input.toCharArray()));
    }

    public static char[] formatString(char[] ch) {
        int swapPos=ch.length-1;
        int startPos =0;
        char temp;
        while(startPos<swapPos) {
            if(isOtherChars(ch[startPos])) {
                while(isOtherChars(ch[swapPos])&&swapPos>startPos) {
                    swapPos--;
                }
                temp=ch[startPos];
                ch[startPos]=ch[swapPos];
                ch[swapPos]=temp;
                swapPos--;
            }
            startPos++;
        }
        swapPos=ch.length-1;
        startPos = 0;
        while (swapPos>startPos) {
            if(isCaps(ch[startPos])) {
                while((isOtherChars(ch[swapPos])||isCaps(ch[swapPos]))&&(swapPos>startPos)) {
                    swapPos--;
                }
                temp=ch[startPos];
                ch[startPos]=ch[swapPos];
                ch[swapPos]=temp;
                swapPos--;
            }
            startPos++;
        }
        return ch;
    }

    public static boolean isCaps(char c) {
        return ((int)c>64&&(int)c<91)? true:false;
    }
    public static boolean isLower(char c) {
        return ((int)c>96&&(int)c<123)?true:false;
    }
    public static  boolean isOtherChars(char c) {
        return !(isLower(c)||isCaps(c));
    }
}
