/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class pair{
        TreeNode node;
        int dis;
        
        public pair(TreeNode node, int dis)
        {
            this.node=node;
            this.dis=dis;
        }
    }
    
    public void createParent(TreeNode root, Map<TreeNode,TreeNode>parent)
    {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        parent.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode front=q.poll();
            
            if(front.left!=null)
            {
                parent.put(front.left,front);
                q.add(front.left);
            }
            if(front.right!=null)
            {
                parent.put(front.right,front);
                q.add(front.right);
            }
        }
    }
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        createParent(root,parent);
        List<Integer>ans=new ArrayList<>();
        Map<TreeNode, Boolean>mp=new HashMap<>();
        mp.put(target,true);
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(target,0));
        
        while(!q.isEmpty())
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                pair front=q.poll();
                TreeNode node=front.node;
                int dis=front.dis;
                if(dis==k)
                    ans.add(node.val);
                
                //left Node
                if(node.left!=null && !mp.containsKey(node.left))
                {
                    mp.put(node.left,true);
                    q.add(new pair(node.left,dis+1));
                }
                // Right Node
                if(node.right!=null && !mp.containsKey(node.right))
                {
                    mp.put(node.right,true);
                    q.add(new pair(node.right,dis+1));
                }
                // Parent Check
                if(parent.get(node)!=null &&  !mp.containsKey(parent.get(node)))
                {
                    mp.put(parent.get(node),true);
                    q.add(new pair(parent.get(node),dis+1));
                }
            }
        }
        return ans;
    }
}