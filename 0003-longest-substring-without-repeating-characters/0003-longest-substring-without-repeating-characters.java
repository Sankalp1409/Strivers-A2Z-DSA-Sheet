class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer>mp=new HashMap<>();
        
        int i=0,j=0;
        int len=0;
        while(j<s.length())
        {
            char ch=s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            
            while(mp.get(ch)>1)
            {
                char c=s.charAt(i);
                if(mp.get(c)==1)
                    mp.remove(c);
                else
                    mp.put(c,mp.get(c)-1);
                i++;
            }
            len=Math.max(len,j-i+1);
            j++;
        }
        
        return len;
    }
}