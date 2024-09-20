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
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode os=null,oe=null;
        ListNode es=null,ee=null;
        
        boolean flag=true;
        ListNode ptr=head;
        while(ptr!=null)
        {
            if(flag)
            {
                if(os==null)
                {
                    os=ptr;
                    oe=ptr;
                }
                else
                {
                    oe.next=ptr;
                    oe=oe.next;
                }
                flag=false;
            }
            else
            {
                if(es==null)
                {
                    es=ptr;
                    ee=ptr;
                }
                else
                {
                    ee.next=ptr;
                    ee=ee.next;
                }
                flag=true;
            }
            ptr=ptr.next;
        }
        
        ee.next=null;
        oe.next=es;
        return os;
        
    }
}