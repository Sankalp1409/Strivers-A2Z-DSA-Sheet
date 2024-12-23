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
        int first,second;
        
        public pair(int first, int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            return p1.first-p2.first;
        }
    }
    public int findMinimumSwap(ArrayList<Integer>arr)
    {
        ArrayList<pair>list=new ArrayList<>();
        
        for(int i=0;i<arr.size();i++)
            list.add(new pair(arr.get(i),i));
        
        Collections.sort(list,new comp());
        
        int i=0;
        int swap=0;
        
        while(i<arr.size())
        {
            int originalIndex=list.get(i).second;
            
            if(originalIndex!=i)
            {
                pair temp=list.get(originalIndex);
                list.set(originalIndex,list.get(i));
                list.set(i,temp);
                swap++;
            }
            else
                i++;
        }
        return swap;
    }
    
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        int count=0;
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode front=q.poll();
                arr.add(front.val);
                
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            count+=findMinimumSwap(arr);
        }
        return count;
    }
}