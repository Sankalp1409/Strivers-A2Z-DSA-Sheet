class Solution {
    public String removeOuterParentheses(String s) {
        StringBuffer ans=new StringBuffer();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(ch=='(')
            {
                if(st.size()!=0)
                    ans.append(ch+"");
                st.push(ch);
            }
            else
            {
                if(st.size()!=1)
                    ans.append(")");
                st.pop();
            }
        }
        return ans.toString();
        
    }
}