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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            long sum=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode front=q.poll();
                sum+=front.val;
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            if(pq.size()<k)
                pq.add(sum);
            else
            {
                if(sum > pq.peek())
                {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        if(pq.isEmpty() || pq.size()<k) return -1;
        return pq.peek();
    }
}