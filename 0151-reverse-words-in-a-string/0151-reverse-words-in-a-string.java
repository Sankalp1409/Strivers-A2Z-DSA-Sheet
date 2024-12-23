class Solution {
    public String reverseWords(String s) {
        
        Stack<String>st=new Stack<>();
        StringBuffer ansString =new StringBuffer();
        s=s.trim();
        String word="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
            {
                st.push(word);
                word="";
            }
            else
                word+=ch;
        }
        
        if(word.length()!=0)
            st.push(word);
        while(!st.isEmpty())
        {
            if(st.size()!=1 && st.peek().length()>0)
                ansString.append(st.pop()+" ");
            else
                ansString.append(st.pop());
        }
        return ansString.toString();
        
    }
}