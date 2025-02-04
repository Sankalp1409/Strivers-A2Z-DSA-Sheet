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
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode ptr=root;

        while(ptr!=null)
        {
            if(ptr.val==val)
                return ptr;
            else if(ptr.val>val)
                ptr=ptr.left;
            else
                ptr=ptr.right;
        }

        return null;
    }
}