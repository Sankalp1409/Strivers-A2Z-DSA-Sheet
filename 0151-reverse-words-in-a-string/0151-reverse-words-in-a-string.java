class Solution {
    public String reverseWords(String s) {
        
        s=s.trim();
        StringBuffer sentence=new StringBuffer();
        Stack<String>st=new Stack<>();
        String word="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch!=' ')
                word+=ch;
            else
            {
                if(word.length()>0)
                    st.push(word);
                word="";
            }
        }
        st.push(word);
        word="";
        
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