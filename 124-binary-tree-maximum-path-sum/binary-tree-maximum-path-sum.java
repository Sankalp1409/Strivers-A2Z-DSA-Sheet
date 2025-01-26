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

    public int solve(TreeNode root, int []arr)
    {
        if(root==null)
            return 0;
        
        int left=solve(root.left,arr);
        int right=solve(root.right,arr);

        if(left<0)
            left=0;
        if(right<0)
            right=0;
        arr[0]=Math.max(arr[0],left+right+root.val);

        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        int []arr=new int[1];
        arr[0]=Integer.MIN_VALUE;
        solve(root,arr);
        return arr[0];
    }
}