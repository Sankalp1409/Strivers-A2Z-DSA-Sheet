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
    
    class pair{
        int pos;
        TreeNode node;
        public pair(TreeNode node, int pos)
        {
            this.node=node;
            this.pos=pos;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        int maxWidth=0;
        Queue<pair>q=new LinkedList<>();
        
        q.add(new pair(root,0));
        
        while(!q.isEmpty())
        {
            int size=q.size();
            int minValue=q.peek().pos;
            int start=0,end=0;
            for(int i=0;i<size;i++)
            {
                pair front=q.poll();
                int index=front.pos-minValue;
                if(i==0)
                    start=front.pos;
                if(i==size-1)
                    end=front.pos;
                
                if(front.node.left!=null)
                    q.add(new pair(front.node.left,2*(index)+1));
                if(front.node.right!=null)
                    q.add(new pair(front.node.right,2*(index)+2));
            }
            
            maxWidth=Math.max(maxWidth,end-start+1);
        }
        return maxWidth;
    }
}