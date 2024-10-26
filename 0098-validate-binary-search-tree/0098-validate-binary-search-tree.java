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
    
    class pair{
        long mini,maxi;
        boolean isBst;
        
        public pair(long mini,long maxi, boolean isBst)
        {
            this.mini=mini;
            this.maxi=maxi;
            this.isBst=isBst;
        }
    }
    
    public pair solve(TreeNode root)
    {
        if(root==null)
            return new pair(Long.MAX_VALUE,Long.MIN_VALUE,true);
        
        pair left=solve(root.left);
        pair right=solve(root.right);
        
        if(left.isBst && right.isBst && left.maxi < root.val && right.mini > root.val)
            return new pair(Math.min(left.mini,root.val),Math.max(right.maxi,root.val),true);
        return new pair(Math.min(left.mini,root.val),Math.max(right.maxi,root.val),false);
    }
    
    
    public boolean isValidBST(TreeNode root) {
        
        return solve(root).isBst;
    }
}