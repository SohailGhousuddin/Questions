import java.security.PublicKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Temp {

    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>(Arrays.asList("A","B"));
        Queue<String> q = s;
        System.out.println((q.remove()));

        System.out.println((q.remove()));

    }
}
