class List{
 private Double item;
 private List next;

 List(Double element)
 {
     this.item=element;
     this.next = null;
 }

    public Double deleteElement1(List l, Double d)
    {
        List curr = l;
        Double d1 = 0.0;

        if(curr.item.equals(d))  {
            System.out.println("Single item");
            d1=curr.item;
            curr.item=null;
            return d1;
        }

            while((curr.next!=null)&&(!curr.next.item.equals(d)))
            {
               curr=curr.next;
            }
            if((curr.next==null)||(!curr.next.item.equals(d))) {
                d1 = null;
                return d1;
            }
            d1=curr.next.item;
            curr.next=curr.next.next;

            return d1;

    }
public Double deleteElement2(List l, Double d)
{
    List curr = l;
    List prev=l;
    if(l==null) return null;

    if(curr.item.equals(d))  {
        System.out.println("Single item");
        l.item=null;
    }
    else  {
        curr = curr.next;
        System.out.println(curr.item);
        while((curr!=null)&&(!curr.item.equals(d)))
        {
            System.out.println(curr.item);
            prev=prev.next;
            curr=curr.next;
        }
        prev.next = curr.next;
        curr.next=null;
    }
    return curr.item;

}
 public void addElement(List l, Double d)
 {
     List ptr = l;
     if(ptr.item==null)      {
         ptr.item=d;
     }
     else {
         while (ptr.next != null) {
             ptr = ptr.next;
         }
         List temp = new List(d);
         ptr.next = temp;
     }
 }
 public void printList(List l)
 {
     System.out.println();
     List ptr = l;
     do
     {
         System.out.print(ptr.item+"|o-> ");
         ptr = ptr.next;
     }while(ptr!=null);
     System.out.println("null");
 }

 // This will not work, as for Collections we cannot change the
 //  reference , here we are trying to add new element and return as head
 public void insertPos(List l, int pos, Double d )
 {
     List curr = l;
     List temp = new List(d);
     if(pos==0)
     {
         temp.next=l;
         l=temp;
     }
 }

    // This will not work, as for Collections we cannot change the
    //  reference , here we are trying to add new element and return as head
    public List insertAtPos(List l, int pos, Double d )
    {
        List curr = l;
        List temp = new List(d);
        if(pos==0)
        {
            temp.next=l;
            l=temp;
            return l;
        }
        int i = 0;
        while(i!=pos-1&&
                curr.next!=null)
        {
            curr=curr.next;
            i++;
        }
        if(i!=pos-1) {
            System.out.println("Position does not exists");
            return l;
        }
        temp.next=curr.next;
        curr.next=temp;
        return l;
    }

    public List deleteFromPos(List l, int pos)
    {
        List curr=l;
        if(pos==0)
        {
            curr=curr.next;
            return curr;
        }

        int i=0;
        while(i!=pos-1 && curr.next!=null)
        {
            curr = curr.next;
            i++;
        }
        curr.next=null;
        return l;
    }

 public List recReverse(List head)
 {

     if(head == null) {
         return head;
     }

     // last node or only one node
     if(head.next == null) {
         return head;
     }

     List newHeadNode = recReverse(head.next);

     // change references for middle chain
     head.next.next = head;
     head.next = null;

     // send back new head node in every recursion
     return newHeadNode;
 }

public List rec2(List head)
{
    if(head==null || head.next==null) return head;
    List newNode = rec2(head.next);

    return head;
}


 public static void main(String[] args)
 {
     List l = new List(10.0);
     l.addElement(l,20.0);
     l.addElement(l,30.0);
     l.printList(l);
     l=l.recReverse(l);
     l.printList(l);
     /*
     l.deleteElement1(l,20.0);
     l.printList(l);
     l.deleteElement1(l,30.0);
     l.printList(l);
    // l.deleteElement1(l,10.0);
     l.printList(l);
     l = l.insertAtPos(l,0,5.0);
     l.printList(l);
     l = l.insertAtPos(l,1,7.0);
     l.printList(l);
     l = l.reverseList(l);
     System.out.println("Before delete");
     l.printList(l);
     //l.deleteFromPos(l,0);
     l.printList(l);
     System.out.println("After delete");
     l=l.reverseList(l);
     l.printList(l);

     l = l.recReverse(l);
     l.printList(l);

      */
 }
}