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
    
    TreeNode prev,first,middle,last;
    
    public void solve(TreeNode root)
    {
        if(root==null)
            return ;
        
        solve(root.left);
        if(prev!=null && root.val < prev.val)
        {
            if(first==null)
            {
                first=prev;
                middle=root;
            }
            else
                last=root;
        }
        prev=root;
        solve(root.right);
    }
    
    public void swap(TreeNode t1, TreeNode t2)
    {
        int temp=t1.val;
        t1.val=t2.val;
        t2.val=temp;
    }
    
    public void recoverTree(TreeNode root) {
        
        solve(root);
        if(last==null)
            swap(first,middle);
        else
            swap(first,last);
    }
}