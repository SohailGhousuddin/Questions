import java.util.ArrayList;
import java.util.List;

public class TrieExample {
    public static void main(String[] args) {
        final List<String> setOfString = new ArrayList<>();
        setOfString.add("pqrs");
        setOfString.add("prrs");
        Trie t = new Trie();
        t.insert(setOfString.get(0));
        t.insert(setOfString.get(1));
        System.out.println(t);
        System.out.println( t.search("pqrs"));
        System.out.println( t.search("pqts"));
    }
}

class Trie {
    final TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }
//Function to search

    public int search(String s) {
        TrieNode current = root;
        System.out.println(current.c);
        for (int i = 0; i < s.length(); i++) {
            if (current == null) { return 0; }

            current = current.next(s.charAt(i));
           if(current!=null)
            System.out.println(current.c);

        }
        return current.terminating;
    }
    //Function to create trie
    public void insert(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current.trieNodes[s.charAt(i)-'a'] == null) {
                current.trieNodes[s.charAt(i)-'a'] = new TrieNode(s.charAt(i));
            }
            current = current.next(s.charAt(i));
        }
        current.terminating++;
    }


    // Actual trie node
    class TrieNode {
        int terminating;
        final TrieNode[] trieNodes = new TrieNode[26];
        char c;

        public  TrieNode(char c)
        {
            this.c = c;
        }

        public TrieNode next(final char c) {
            return trieNodes[c - 'a'];
        }
    }

}