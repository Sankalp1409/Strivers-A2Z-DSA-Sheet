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
    
    public TreeNode solve(TreeNode root,TreeNode curr)
    {
        while(root.right!=null && root.right!=curr)
            root=root.right;
        return root;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>list=new ArrayList<>();
        TreeNode curr=root;
        
        while(curr!=null)
        {
            if(curr.left==null)
            {
                list.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode succ=solve(curr.left,curr);
                if(succ.right==curr)
                {
                    succ.right=null;
                    list.add(curr.val);
                    curr=curr.right;
                }
                else
                {
                    succ.right=curr;
                    curr=curr.left;
                }
            }
        }
        return list;
    }
}