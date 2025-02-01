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

    public TreeNode findPredecessor(TreeNode root, TreeNode ptr)
    {
        while(root.right!=null && root.right!=ptr)
            root=root.right;
        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ansList=new ArrayList<>();

        TreeNode ptr=root;
        while(ptr!=null)
        {
            if(ptr.left!=null)
            {
                TreeNode pred=findPredecessor(ptr.left,ptr);
                if(pred.right!=ptr)
                {
                    pred.right=ptr;
                    ptr=ptr.left;
                    }
                else
                {
                    ansList.add(ptr.val);
                    pred.right=null;
                    ptr=ptr.right;
                }
            }
            else
            {
                ansList.add(ptr.val);
                ptr=ptr.right;
            }
        }
        return ansList;
    }
}