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
    
    public TreeNode solve(int []preorder,int []inorder,int preStart, int preEnd, 
                     int inStart, int inEnd, HashMap<Integer,Integer>mp)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root=new TreeNode(preorder[preStart]);
        int index=mp.get(preorder[preStart]);
        int ele=index-inStart;
        
        root.left=solve(preorder,inorder,preStart+1,preStart+ele,inStart,index-1,mp);
        root.right=solve(preorder,inorder,preStart+ele+1,preEnd,index+1,inEnd,mp);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mp.put(inorder[i],i);
        return solve(preorder,inorder,0,preorder.length-1,0,inorder.length-1,mp);
    }
}