package Tree;

import java.net.Socket;
import java.util.function.Predicate;

public class TreeCreation {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int v, Node l, Node r) {
            val = v;
            left = l;
            right = r;
        }
    };

    public static void main(String[] args) {
        /*
                            50
                  30                 80
              20      40         70       90
           10                60

         */
       Node n = new Node(10,null,null);
       Node n1= new Node(20,n,null);
        Node n5 = new Node(60,null,null);
        Node n3 = new Node(40,null,null);
        Node n2 = new Node(30,n1,n3);
        Node n8 = new Node(90,null,null);
        Node n6 = new Node(70,n5,null);
        Node n7 = new Node(80,n6,n8);
        Node n4 = new Node(50,n2,n7);

        Node Root = n4;
        System.out.println("Pre order");
        PREOrder(Root);
        System.out.println("In order");
        InOrder(Root);
        System.out.println("Post order");
        PostOrder(Root);


    }

    public static void PREOrder(Node root)
    {
        System.out.println(root.val);
        if(root.left!=null)PREOrder(root.left);
        if(root.right!=null)PREOrder(root.right);
    }

    public static void InOrder(Node root)
    {

        if(root.left!=null)InOrder(root.left);
        System.out.println(root.val);
        if(root.right!=null)InOrder(root.right);

    }

    public static void PostOrder(Node root)
    {

        if(root.left!=null)PostOrder(root.left);
        if(root.right!=null)PostOrder(root.right);
        System.out.println(root.val);

    }
}
