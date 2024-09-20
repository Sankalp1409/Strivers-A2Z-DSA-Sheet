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
    
    public ListNode reverseLinkedList(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
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
    
    public boolean isPalindrome(ListNode head) {
        
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if(fast==null)
            prev.next=null;
        
        ListNode rev=reverseLinkedList(slow);
        ListNode start=head;
        
        while(rev!=null && start!=null)
        {
            if(rev.val!=start.val)
                return false;
            rev=rev.next;
            start=start.next;
        }
        return true;
    }
}