package Questions;

import java.util.List;

public class AddTwoList {
    public static void main(String[] args)
    {   // l1 2->4->9 -- 942
        // l2 9->3->6 -- 639
        // result 942+639 = 1581  1->8->5->1
        int[] a1={9};
        int[] a2 ={1,9,9,9,9,9,8,9,9,9};
        ListNode l1 = new ListNode(9,null);
        ListNode l2 = new ListNode(1,null);
        createList(l1,a1);
        createList(l2,a2);
        ListNode res = addTwoNumbers(l1,l2);
        System.out.println(addTwoNumbers(l1,l2));
        for(ListNode i=res;i!=null;i=i.next)
        {
            if(i==res)
            System.out.print(i.val);
            else System.out.print("->"+i.val);
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        if (l1 == null && l2 == null) return l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode resPtr = null;
        int res = 0;
        ListNode temp;
        do {
            res = ptr1.val + ptr2.val;

            if (result == null) // result first node
            {
                // res is greater then 10 , we have to create two new nodes
                temp = res > 9 ? new ListNode(res % 10, null) : new ListNode(res, null);
                result = resPtr = temp;
                temp = res > 9 ? new ListNode(res / 10, null) : temp;
                result.next = resPtr != temp ? temp : null;

            } else {
                if (resPtr.next != null) {
                    res = res + resPtr.next.val;
                    if (res >= 10) {
                        temp = new ListNode(res/ 10, null);
                        resPtr.next.val = res % 10;
                        resPtr.next.next = temp;
                        resPtr = resPtr.next;
                    } else {
                        resPtr.next.val = res;
                        resPtr = resPtr.next;
                    }
                } else { // for the last node add condition here
                    if (res >= 10) {
                        temp = new ListNode(res % 10, null);
                        resPtr.next = temp;
                        resPtr = resPtr.next;
                        temp = new ListNode(res / 10, null);
                        resPtr.next = temp;


                    } else {
                        temp = new ListNode(res, null);
                        resPtr.next = temp;
                        resPtr = temp;
                    }

                }
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        } while (ptr1 != null && ptr2 != null);

        for (; ptr1 != null; ptr1 = ptr1.next) { // only first list has still some more elements
            if(resPtr.next!=null) // we have a carry so add
            {
                res= ptr1.val+ resPtr.next.val;
                if (res >= 10) {
                    temp = new ListNode(res % 10, null);
                    resPtr.next = temp;
                    resPtr = resPtr.next;
                    temp = new ListNode(res / 10, null);
                    resPtr.next = temp;


                } else {

                    resPtr.next.val = res;
                    resPtr=resPtr.next;

                }

            }
            else{

                    temp = new ListNode(ptr1.val, null);
                    resPtr.next = temp;
                    resPtr = temp;
                }
            }


        for (; ptr2 != null; ptr2 = ptr2.next) { // only second list has still some more elements
            if(resPtr.next!=null) // we have a carry so add
            {
                res= ptr2.val+ resPtr.next.val;
                if (res >= 10) {
                    temp = new ListNode(res % 10, null);
                    resPtr.next = temp;
                    resPtr = resPtr.next;
                    temp = new ListNode(res / 10, null);
                    resPtr.next = temp;


                } else {

                    resPtr.next.val = res;
                    resPtr=resPtr.next;

                }

            }
            else{

                temp = new ListNode(ptr2.val, null);
                resPtr.next = temp;
                resPtr = temp;
            }
        }


        return result;
    }
    public static void createList(ListNode l1,int[] a1)
    {
        ListNode ptr =l1;
        ListNode temp=null;
        for(int i = 1;i< a1.length;i++)
        {
             temp = new ListNode(a1[i],null);

            while(ptr.next!=null)
            {
                ptr=l1.next;
            }
            ptr.next=temp;
            ptr=ptr.next;
        }
    }
}
