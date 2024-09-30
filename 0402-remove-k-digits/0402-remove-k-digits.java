class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.length()==k) return "0";
        Stack<Character>st=new Stack<>();
        String ans="";
        for(int i=0;i<num.length();i++)
        {
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k>0)
            {
                st.pop();
                k--;
            }
            if(!st.isEmpty() || num.charAt(i)!='0')
                st.push(num.charAt(i));
        }
        
        while(!st.isEmpty() && k>0)
        {
            st.pop();
            k--;
        }
        
        if(st.isEmpty()) return "0";
        
        while(!st.isEmpty())
            ans=st.pop()+ans;
        
        return ans;
    }
}