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
        boolean isReverse;

        public BstIterator(TreeNode root, boolean isReverse)
        {
            st=new Stack<>();
            this.isReverse=isReverse;
            add(root);
        }

        public void add(TreeNode root)
        {
            if(root==null)
                return ;
            
            st.push(root);
            if(isReverse)
                add(root.right);
            else
                add(root.left);
        }

        public int next()
        {
            TreeNode top=st.pop();
            if(isReverse)
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
            System.out.println(i+" "+j);
            if(i+j==k)
                return true;
            else if(i+j>k)
                j=backward.next();
            else
                i=forward.next();
        }

        return false;
    }
}