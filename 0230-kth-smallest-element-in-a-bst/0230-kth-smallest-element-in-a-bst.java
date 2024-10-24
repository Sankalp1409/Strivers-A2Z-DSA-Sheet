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
    
    public TreeNode findPredecessor(TreeNode node, TreeNode curr)
    {
        while(node.right!=null && node.right!=curr)
            node=node.right;
        return node;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                TreeNode ptr=findPredecessor(curr.left,curr);
                if(ptr.right==curr)
                {
                    --k;
                    if(k==0)
                        return curr.val;
                    ptr.right=null;
                    curr=curr.right;
                }
                else
                {
                    ptr.right=curr;
                    curr=curr.left;
                }
            }
            else
            {
                --k;
                if(k==0)
                    return curr.val;
                curr=curr.right;
            }
        }
        return -1;
    }
}