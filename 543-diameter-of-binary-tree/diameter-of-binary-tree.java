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
        int height, diameter;

        public pair(int height, int diameter)
        {
            this.height=height;
            this.diameter=diameter;
        }
    }

    public pair solve(TreeNode root)
    {
        if(root==null)
            return new pair(0,0);
        if(root.left==null && root.right==null)
            return new pair(1,1);
        
        pair left=solve(root.left);
        pair right=solve(root.right);

        int diameter=Math.max(left.diameter,Math.max(right.diameter,left.height+right.height+1));
        int height=Math.max(left.height,right.height)+1;

        return new pair(height,diameter);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        return solve(root).diameter-1;
    }
}