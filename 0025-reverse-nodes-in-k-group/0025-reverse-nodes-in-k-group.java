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
    
    public int countNode(ListNode head)
    {
        int count=0;
        
        while(head!=null)
        {
            head=head.next;
            count++;
        }
        return count;
    }
    
    public ListNode solve(ListNode head, int k , int len)
    {
        if(len<k) return head;
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode forward=null;
        
        int count=0;
        while(curr!=null && count<k)
        {
            forward=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            count++;
        }
        
        head.next=solve(curr,k,len-k);
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int length=countNode(head);
        return solve(head,k,length);
    }
}