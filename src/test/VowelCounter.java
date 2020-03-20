package test;




import java.util.*;
import java.util.stream.Stream;

public class VowelCounter {

    private Comparator<Token> tokenComparator;
    private PriorityQueue<Token> tokenPriorityQueue;

    public VowelCounter() {
        tokenPriorityQueue = new PriorityQueue<Token>(6,new TokenComparator());
    }

    public static void main(String[] args) {
        String  input = "A sky fly tournament is a competition involving many teams.";
        String str;
        VowelCounter vc = new VowelCounter();
        Scanner sc = new Scanner(input);
        while (sc.hasNext()) {
            str = sc.next();
            vc.addToken(str,vc.getVowelsCount(str));
        }
        vc.printTop(3);
    }

    private void addToken(String aString,int vCount) {
        this.tokenPriorityQueue.add(new Token(aString,vCount));
    }

    private int getVowelsCount(String aString) {
        int vowelCount = 0;
        ArrayList<Character> charArray = new ArrayList<Character>(List.of('a','e','i','o','u'));
        char[] str = aString.toLowerCase().toCharArray();
        for(char c : str)
            vowelCount = charArray.contains(c) ? vowelCount=vowelCount+1 : vowelCount;
        return vowelCount;
    }

    public void printTop(int aDisplayTop) {
        Token t = new Token();
        System.out.println("Top "+aDisplayTop+" words with vowel count is:");
        for(int count=0;(!this.tokenPriorityQueue.isEmpty())&&(count<aDisplayTop);count++) {
            t = this.tokenPriorityQueue.poll();
            System.out.println(count+1+": "+t.getToken()+" : "+t.getTokenLength());
        }
    }
}