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

    TreeNode first,mid,last,prev;
    public void solve(TreeNode root)
    {
        if(root==null)
            return ;
        
        solve(root.left);
        if(prev!=null && prev.val > root.val)
        {
            if(first==null)
            {
                first=prev;
                mid=root;
            }
            else
            {
                last=root;
            }
        }
        prev=root;
        solve(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        solve(root);
        if(last==null)
        {
            int temp=first.val;
            first.val=mid.val;
            mid.val=temp;
        }
        else
        {
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
    }
}