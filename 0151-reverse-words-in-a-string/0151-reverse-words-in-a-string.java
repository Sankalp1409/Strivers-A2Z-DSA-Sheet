class Solution {
    public String reverseWords(String s) {
        
        Stack<String>st=new Stack<>();
        s=s.trim();
        String word="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
            {
                if(word.length()!=0)
                    st.push(word);
                word="";
            }
            else
                word+=ch;
        }
        if(word.length()!=0)
            st.push(word);
        
        
        StringBuffer sentence =new StringBuffer();
        
        while(!st.isEmpty())
        {
            if(st.size()==1)
                sentence.append(st.peek());
            else
                sentence.append(st.peek()+" ");
            st.pop();
        }
        
        return sentence.toString();
    }
}