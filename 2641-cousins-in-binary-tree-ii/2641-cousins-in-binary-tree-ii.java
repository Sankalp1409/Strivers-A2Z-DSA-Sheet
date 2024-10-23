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
    
    public TreeNode solve(TreeNode root, List<Integer>list)
    {
        Queue<TreeNode>q=new LinkedList<>();
        root.val=0;
        q.add(root);
        int i=1;
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int idx=0;idx<size;idx++)
            {
                TreeNode front=q.poll();
                int diff=0;
                if(front.left!=null && front.right!=null)
                {
                    // System.out.println(front.left.val+" "+front.right.val);
                    if(i<list.size())
                        diff=list.get(i)-(front.left.val+front.right.val);
                    front.left.val=diff;
                    front.right.val=diff;
                    q.add(front.left);
                    q.add(front.right);
                }
                else if(front.left!=null)
                {
                    if(i<list.size())
                        diff=list.get(i)-front.left.val;
                    front.left.val=diff;
                    q.add(front.left);
                }
                else if(front.right!=null)
                {
                    if(i<list.size())
                        diff=list.get(i)-front.right.val;
                    front.right.val=diff;
                    q.add(front.right);
                }
            }
            i++;
        }
        return root;
    }
    
    public TreeNode replaceValueInTree(TreeNode root) {
        
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode front=q.poll();
                sum+=front.val;
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            list.add(sum);
        }
        
        // for(int i:list)
        //     System.out.print(i+" ");
        return solve(root,list);
    }
}