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

    public TreeNode solve(int []preorder, int []idx, int maxi)
    {
        if(idx[0]>=preorder.length)
            return null;
        
        if(preorder[idx[0]]>=maxi)
            return null;
        
        TreeNode root=new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left=solve(preorder,idx,root.val);
        root.right=solve(preorder,idx,maxi);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int []idx=new int[1];
        idx[0]=0;
        return solve(preorder,idx,Integer.MAX_VALUE);
    }
}