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
    
        
    public TreeNode solve(int []inorder,int []postorder, int  postStart, int postEnd, 
                          int inStart, int inEnd, HashMap<Integer,Integer>mp)
    {
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        TreeNode root=new TreeNode(postorder[postEnd]);
        int index=mp.get(postorder[postEnd]);
        int ele=inEnd-index;
        root.right=solve(inorder,postorder,postEnd-ele,postEnd-1,index+1,inEnd,mp);
        root.left=solve(inorder,postorder,postStart,postEnd-ele-1,inStart,index-1,mp);
        
        return root;
    }
        
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mp.put(inorder[i],i);
        return solve(inorder,postorder,0, postorder.length-1, 0, inorder.length-1,mp);
        
    }
}