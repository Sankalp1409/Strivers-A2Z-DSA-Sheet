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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null)
            return head;
        int count=1;
        ListNode ptr=head;
        
        while(ptr.next!=null)
        {
            ptr=ptr.next;
            count++;
        }
        k=k%count;
        if(k==0)
            return head;
        int size=count-k;
        ListNode start=head;
        ListNode prev=null;
        while(size>0)
        {
            prev=start;
            start=start.next;
            size--;
        }
        ptr.next=head;
        prev.next=null;
        return start;
    }
}