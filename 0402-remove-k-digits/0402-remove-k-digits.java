class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character>st=new Stack<>();
        String ans="";
        for(int i=0;i<num.length();i++)
        {
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k>0)
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(k>0)
        {
            st.pop();
            k--;
        }
        
        if(st.isEmpty()) return "0";
        
        while(!st.isEmpty())
            ans=st.pop()+ans;
        
        int idx=0;
        while(idx<ans.length())
        {
            if(ans.charAt(idx)=='0')
                idx++;
            else
                break;
        }
        if(idx==ans.length()) return "0";
        
        if(idx!=0) return ans.substring(idx);
        
        return ans;
    }
}