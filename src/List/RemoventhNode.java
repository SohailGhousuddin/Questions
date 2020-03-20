package List;

public class RemoventhNode {


      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
          ListNode(int x,ListNode n) { val = x; next=n; }
      };


      public static void main(String[] args)
      {

          /*
          [1,2,3,4,5,6,7,8,9,10]
7
           */
          ListNode n = new ListNode(10,null);
          ListNode n1 = new ListNode(20,n);
          ListNode n2 = new ListNode(30,n1);
         ListNode n3 = new ListNode(40,n2);
          ListNode n4 = new ListNode(50,n3);
          ListNode n5 = new ListNode(60,n4);

          ListNode root = n5;
          printList(root);
         root = removeNthFromEnd(root,5);
          printList(root);

      }
        public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1,p2;
        p1=head;
        p2=head;
        int i=n;
        for(;i>0&&p2.next!=null;i--)
        {
            p2=p2.next;

        }
        if(i==n){ head = null; return head;}
        if(i==1){head=head.next;return head;}
        if(i>1){return head;}
        while(p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next;
        }
         //   System.out.println( "\n"+p1.next.val);
        if(p1.next==p2) {
            p1.next = null;
        }else
            p1.next=p1.next.next;


            return head;
        }
        public static void printList(ListNode head)
        {
            ListNode p = head;
            System.out.println("\n");
            while(p!=null)
            {
                System.out.print(p.val+"->");
                p=p.next;
            }
            //if(p!=null) System.out.print(p.val);
        }
    }

