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
    
    public TreeNode solve(TreeNode root)
    {
        root=root.left;
        while(root.right!=null)
            root=root.right;
        return root;
    }
    
    public void flatten(TreeNode root) {
        
        if(root==null)
            return ;
        
        if(root.left==null)
            root=root.right;
        else
        {
            TreeNode succ=solve(root);
            succ.right=root.right;
            root.right=root.left;
            root.left=null;
            root=root.right;
        }
        flatten(root);
    }
}