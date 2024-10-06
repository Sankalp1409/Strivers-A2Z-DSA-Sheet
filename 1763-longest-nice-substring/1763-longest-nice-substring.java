class Solution {
    public String longestNiceSubstring(String s) {
        
        Set<Character>st=new HashSet<>();
        for(int i=0;i<s.length();i++)
            st.add(s.charAt(i));
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(st.contains(Character.toUpperCase(ch)) && st.contains(Character.toLowerCase(ch)))
               continue;
               String left=longestNiceSubstring(s.substring(0,i));
               String right=longestNiceSubstring(s.substring(i+1));
               
               return left.length()>=right.length() ? left:right;
        }
        return s;
    }
}