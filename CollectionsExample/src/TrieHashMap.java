import java.util.ArrayList;
import java.util.HashMap;


public class TrieHashMap {
    public static void main(String[] args) {
        ArrayList<String> istr = new ArrayList<String>();
        istr.add("abc");

        trie t = new trie();
        t.insert(istr.get(0));
        System.out.println(t.search("abc"));
        System.out.println(t.search("vabc"));
    }

}

class trie {
    TrieNode root;
    public trie() {
        root = new TrieNode('\0');
    }
    public int search(String s) {
        TrieNode current = root;
        for(int i=0;i<s.length();i++) {
           if( current.getNext(s.charAt(i))==null) return 0;
           current = current.getNext(s.charAt(i));
           if(current!=null) { System.out.println(current.c); }
        }
            return current.endOfString;

    }
    public void insert(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.getNext(s.charAt(i)) == null) {
                TrieNode temp = new TrieNode(s.charAt(i));
                current.trieNodes.put(s.charAt(i),temp);
                current=current.getNext(s.charAt(i));
            }
        }
        current.endOfString++;
    }
}



class TrieNode {
    char c;
    int endOfString;
    HashMap<Character,TrieNode> trieNodes;

    public TrieNode(char c) {
        this.c=c;
        trieNodes = new HashMap<>();
    }
    public TrieNode getNext(char c)
    {
        if(trieNodes!=null)
          return trieNodes.get(c);
        return null;
    }
}
