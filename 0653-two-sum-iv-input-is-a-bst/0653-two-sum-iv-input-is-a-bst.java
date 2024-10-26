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
    
    class BstIterator{
        Stack<TreeNode>st;
        boolean reverse;
        
        public BstIterator(TreeNode root,boolean reverse)
        {
            st=new Stack<>();
            this.reverse=reverse;
            add(root);
        }
        
        public void add(TreeNode root)
        {
            if(root==null)
                return ;
            st.push(root);
            if(reverse)
                add(root.right);
            else
                add(root.left);
        }
        
        public int next()
        {
            TreeNode top=st.pop();
            if(reverse)
                add(top.left);
            else
                add(top.right);
            return top.val;
        }
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        BstIterator forward=new BstIterator(root,false);
        BstIterator backward=new BstIterator(root,true);
        
        int i=forward.next();
        int j=backward.next();
        
        System.out.println(i+" "+j);
        while(i<j)
        {
            if(i+j==k)
                return true;
            else if(i+j > k)
                j=backward.next();
            else
                i=forward.next();
        }
        return false;
        
    }
}