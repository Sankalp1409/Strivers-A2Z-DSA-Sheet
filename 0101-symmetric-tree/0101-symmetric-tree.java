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
    
    public boolean solve(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2==null || root1==null && root2!=null)
            return false;
        
        boolean leftMirror=solve(root1.right,root2.left);
        boolean rightMirror=solve(root1.left,root2.right);
        
        if(leftMirror && rightMirror && root1.val==root2.val)
            return true;
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return solve(root.left,root.right);
    }
}