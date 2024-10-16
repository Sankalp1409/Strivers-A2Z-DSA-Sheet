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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)
            return ans;
        boolean isLeftToRight=true;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            List<Integer>temp=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode front=q.poll();
                temp.add(front.val);
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            if(isLeftToRight==false)
                Collections.reverse(temp);
            ans.add(temp);
            isLeftToRight=!isLeftToRight;
        }
        return ans;
    }
}