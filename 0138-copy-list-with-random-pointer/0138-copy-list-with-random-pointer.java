/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return head;
        
        Node ptr=head;
        
        while(ptr!=null)
        {
            Node p=new Node(ptr.val);
            p.next=ptr.next;
            ptr.next=p;
            ptr=ptr.next.next;
        }
        
        //cloning the random pointers
        
        ptr=head;
        
        while(ptr!=null)
        {
            if(ptr.random==null)
                ptr.next.random=null;
            else
                ptr.next.random=ptr.random.next;
            ptr=ptr.next.next;
        }
        
        Node ptr1=head;
        Node start=head.next;
        Node ptr2=start;
        
        while(ptr1!=null)
        {
            ptr1.next=ptr2.next;
            ptr1=ptr1.next;
            
            if(ptr1==null)
                ptr2.next=null;
            else
            {
                ptr2.next=ptr1.next;
                ptr2=ptr2.next;
            }
        }
        return start;
    }
}