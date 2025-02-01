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

    public TreeNode solve(int []preorder, int []inorder, int ps,int pe, int is, int ie, HashMap<Integer,Integer>mp)
    {
        if(ps>pe || is>ie)
            return null;
        
        TreeNode root=new TreeNode(preorder[ps]);

        int idx=mp.get(preorder[ps]);
        int ele=idx-is;

        root.left=solve(preorder,inorder,ps+1,ps+ele,is,idx-1,mp);
        root.right=solve(preorder,inorder,ps+ele+1,pe,idx+1,ie,mp);
        // root.left=solve(preorder,inorder,ps+1,ps+ele,is,idx-1,mp);
        // root.right=solve(preorder,inorder,ps+ele+1,pe,idx+1,ie,mp);

        return root;


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            mp.put(inorder[i],i);
        return solve(preorder,inorder,0,preorder.length-1,0,inorder.length-1,mp);
    }
}