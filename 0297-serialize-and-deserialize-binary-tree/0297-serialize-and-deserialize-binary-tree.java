/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root==null)
            return "";
        
        StringBuffer sb=new StringBuffer();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            TreeNode front=q.poll();
            
            if(front==null)
                sb.append("#,");
            else
            {
                sb.append(front.val+",");
                q.add(front.left);
                q.add(front.right);
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length()==0)
            return null;
        System.out.println(data);
        String []arr=data.split(",");
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int idx=1;
        while(!q.isEmpty())
        {
            TreeNode front=q.poll();
            if(arr[idx].equals("#"))
                front.left=null;
            else
            {
                front.left=new TreeNode(Integer.parseInt(arr[idx]));
                q.add(front.left);
            }
            idx++;
            if(arr[idx].equals("#"))
                front.right=null;
            else
            {
                front.right=new TreeNode(Integer.parseInt(arr[idx]));
                q.add(front.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));