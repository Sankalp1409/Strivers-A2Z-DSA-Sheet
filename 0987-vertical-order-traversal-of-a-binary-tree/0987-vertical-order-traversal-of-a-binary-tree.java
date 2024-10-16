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
        int pos,level;
        TreeNode node;
        public pair(TreeNode node, int pos, int level)
        {
            this.node=node;
            this.pos=pos;
            this.level=level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Map<Integer,Map<Integer,PriorityQueue<Integer>>>mp=new TreeMap<>();
        
        List<List<Integer>>ans=new ArrayList<>();
        
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(root,0,0));
        
        while(!q.isEmpty())
        {
            pair front=q.poll();
            if(!mp.containsKey(front.pos))
                mp.put(front.pos,new TreeMap<>());
            if(!mp.get(front.pos).containsKey(front.level))
                mp.get(front.pos).put(front.level,new PriorityQueue<Integer>());
            
            mp.get(front.pos).get(front.level).add(front.node.val);
            
            if(front.node.left!=null)
                q.add(new pair(front.node.left,front.pos-1,front.level+1));
            
            if(front.node.right!=null)
                q.add(new pair(front.node.right,front.pos+1,front.level+1));
            
        }
        
        for(Map<Integer,PriorityQueue<Integer>> e:mp.values())
        {
            List<Integer>list=new ArrayList<>();
            for(PriorityQueue<Integer> pq:e.values())
                while(!pq.isEmpty())
                    list.add(pq.poll());
            ans.add(list);
        }
        return ans;
        
    }
}