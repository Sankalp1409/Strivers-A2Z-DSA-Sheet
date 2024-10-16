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
    
    class Pair{
        
        int height,diameter;
        
        public Pair(int height, int diameter)
        {
            this.height=height;
            this.diameter=diameter;
        }
    }
    
    public Pair solve(TreeNode root)
    {
        if(root==null)
            return new Pair(0,0);
        
        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        return new Pair(Math.max(left.height,right.height)+1,
                        Math.max(left.diameter,Math.max(right.diameter,left.height+right.height+1)));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        return solve(root).diameter-1;
        
    }
}