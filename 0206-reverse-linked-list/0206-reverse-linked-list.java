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
    
    public ListNode solve(ListNode head, ListNode prev)
    {
        if(head==null)
            return prev;
        
        ListNode forward=head.next;
        head.next=prev;
        prev=head;
        
        return solve(forward,prev);
    }
    
    public ListNode reverseList(ListNode head) {
        
        return solve(head,null);
        
    }
}