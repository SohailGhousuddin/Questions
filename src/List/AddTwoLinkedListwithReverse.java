package List;

// here logic is , when we add two number and it results in more than 9 then we need to take care of carry
// so create a new node and see if we have carry
public class AddTwoLinkedListwithReverse {
    public static void main(String[] args)
    {   // l1 2->4->9 -- 942
        // l2 9->3->6 -- 639
        // result 942+639 = 1581  1->8->5->1
        int[] a1={9,9};
       // int[] a2 ={1,9,9,9,9,9,8,9,9,9};
        int[] a2 ={1,9};
        ListNode l1 = new ListNode(9,null);
        ListNode l2 = new ListNode(1,null);
        createList(l1,a1);
        createList(l2,a2);
        l2 = reverseList(l2);
        l1=reverseList(l1);
       // System.out.println(l1);
        displayList(l1);
        displayList(l2);
        ListNode res = addTwoNumber(l1,l2);
        res=reverseList(res);
       // System.out.println(addTwoNumbers(l1,l2));


    }
    public static void displayList(ListNode res)
    {
        System.out.println();
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

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {

        ListNode result = null,curr = null;
        if (l1 == null && l2 == null) return l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode op1 = l1,op2 =l2;

        ListNode opRes = null;
        ListNode carryNode = new ListNode(0);
        int carry=0;
        int res=0;
        while(l1!=null||l2!=null)
        {
            res = l1.val+l2.val+carry;
            if (res>9)
            {
                   opRes = new ListNode(res%10,null);
                   carry=res/10;
            }
            else{
                opRes = new ListNode(res,null);
                carry=0;
            }
            if(result==null) {
                result = opRes;
                curr=result;
            }
            else {
                curr.next=opRes;
                curr=opRes;
            }
            l1=l1.next;  l2=l2.next;
        }
        if(l2==null&&l1!=null)
        {
            while(l1!=null)
            {
                res=carry+l1.val;
                if (res>9)
                {
                    opRes = new ListNode(res%10,null);
                    carry=res/10;
                }
                else{
                    opRes = new ListNode(res,null);
                    carry=0;
                }
                curr.next=opRes;
                curr=opRes;
                l1=l1.next;
            }
        }
        if(l1==null&&l2!=null)
        {
            while(l2!=null)
            {
                res=carry+l2.val;
                if (res>9)
                {
                    opRes = new ListNode(res%10,null);
                    carry=res/10;
                }
                else{
                    opRes = new ListNode(res,null);
                    carry=0;
                }
                curr.next=opRes;
                curr=opRes;
                l2=l2.next;
            }
        }
        if(carry>0)
        {
            opRes = new ListNode(carry,null);
            curr.next=opRes;
            curr=opRes;
            carry=0;
        }
        return result;
    }


    public static ListNode reverseList(ListNode l1)
    {
        if(l1==null || l1.next==null) return l1;
        ListNode prev = null;
        ListNode next=null;
        ListNode curr = l1;
        // here we use two extra pointers,
        // prev , next will be null
        // curr will point to next element
        //
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;

        }
        l1=prev;
        return l1;


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
