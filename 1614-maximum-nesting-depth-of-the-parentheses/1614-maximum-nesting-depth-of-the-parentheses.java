class Solution {
    public int maxDepth(String s) {
        
        Stack<Character>st=new Stack<>();
        int maxDepth=0;
        int depth=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(ch);
                depth++;
            }
            else if(ch==')')
            {
                st.pop();
                depth--;
            }
            maxDepth=Math.max(maxDepth,depth);
        }
        return maxDepth;
    }
}