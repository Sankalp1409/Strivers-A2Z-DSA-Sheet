/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode forward=null;
        
        while(curr!=null)
        {
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        int carry=0;
        
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        while(l1!=null && l2!=null)
        {
            int sum=l1.val+l2.val+carry;
            ListNode p=new ListNode(sum%10);
            carry=sum/10;
            ptr.next=p;
            ptr=ptr.next;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null)
        {
            int sum=l1.val+carry;
            ListNode p=new ListNode(sum%10);
            carry=sum/10;
            ptr.next=p;
            ptr=ptr.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int sum=l2.val+carry;
            ListNode p=new ListNode(sum%10);
            carry=sum/10;
            ptr.next=p;
            ptr=ptr.next;
            l2=l2.next;
        }
        
        if(carry!=0)
        {
            ListNode p=new ListNode(carry);
            ptr.next=p;
            ptr=ptr.next;
        }
        ListNode start=dummy.next;
        dummy.next=null;
        return start;
    }
}