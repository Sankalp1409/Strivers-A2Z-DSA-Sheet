class Solution {
    
    public boolean checkValidString(String s) {
        
        Stack<Integer>asterik=new Stack<>();    
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(i);
            else if(ch==')')
            {
                if(st.isEmpty())
                {
                    if(asterik.isEmpty())
                        return false;
                    else
                        asterik.pop();
                }
                else
                    st.pop();
            }
            else
                asterik.push(i);
        }
        
        while(!st.isEmpty())
        {
            if(asterik.isEmpty() || asterik.peek()<st.peek())
                return false;
            asterik.pop();
            st.pop();
        }
        
        return true;
    }
}