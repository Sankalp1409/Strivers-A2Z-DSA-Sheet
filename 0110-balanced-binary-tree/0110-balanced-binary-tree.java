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
        int height;
        boolean isBalance;
        
        public pair(int height,boolean isBalance)
        {
            this.height=height;
            this.isBalance=isBalance;
        }
    }
    pair solve(TreeNode root)
    {
        if(root==null)
            return new pair(0,true);
        
        pair left=solve(root.left);
        pair right=solve(root.right);
        
        if(left.isBalance==false || right.isBalance==false ||Math.abs(left.height-right.height)>1)
            return new pair(left.height,false);
        
        return new pair(Math.max(left.height,right.height)+1,true);
    }
    public boolean isBalanced(TreeNode root) {
        return solve(root).isBalance;
    }
}