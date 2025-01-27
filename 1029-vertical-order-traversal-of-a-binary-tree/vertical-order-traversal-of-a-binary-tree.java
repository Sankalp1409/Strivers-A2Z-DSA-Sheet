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
        public pair(int pos, int level, TreeNode node)
        {
            this.pos=pos;
            this.level=level;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>>ansList=new ArrayList<>();
        Queue<pair>q=new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>>mp=new TreeMap<>();
        q.add(new pair(0,0,root));

        while(!q.isEmpty())
        {
            pair front=q.poll();
            int pos=front.pos;
            int level=front.level;
            TreeNode node=front.node;

            if(!mp.containsKey(pos))
                mp.put(pos,new TreeMap<>());
            if(!mp.get(pos).containsKey(level))
                mp.get(pos).put(level,new PriorityQueue<>());
            mp.get(pos).get(level).add(node.val);

            if(node.left!=null)
                q.add(new pair(pos-1,level+1,node.left));
            if(node.right!=null)
                q.add(new pair(pos+1,level+1,node.right));
        }

        for(Map<Integer,PriorityQueue<Integer>>e:mp.values())
        {
            List<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer> pq:e.values())
            {
                while(!pq.isEmpty())
                    temp.add(pq.poll());
            }
            ansList.add(temp);
        }
        return ansList;
    }
}