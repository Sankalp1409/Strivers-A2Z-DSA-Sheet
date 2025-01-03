/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ptr=new TreeNode(val);
        if(root==null)
        {
            return ptr;
        }
        TreeNode prev=null;
        TreeNode curr=root;
        
        while(curr!=null)
        {
            prev=curr;
            if(val < curr.val)
                curr=curr.left;
            else
                curr=curr.right;
        }
        
        if(val > prev.val)
            prev.right=ptr;
        else if(val<prev.val)
            prev.left=ptr;
        return root;
    }
}