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
    
    public ListNode mergeTwoSortedLinkedList(ListNode left, ListNode right)
    {
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        while(left!=null && right!=null)
        {
            if(left.val < right.val)
            {
                ptr.next=left;
                left=left.next;
            }
            else
            {
                ptr.next=right;
                right=right.next;
            }
            ptr=ptr.next;
        }
        if(right!=null)
            ptr.next=right;
        if(left!=null)
            ptr.next=left;
        
        ListNode start=dummy.next;
        dummy.next=null;
        return start;
    }
    
    public ListNode mergeSort(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        // find middle element
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        prev.next=null;
        
        // call recursive call for two linked lsit
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(slow);
        
        return mergeTwoSortedLinkedList(left,right);
    }
    
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}