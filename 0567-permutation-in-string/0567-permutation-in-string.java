class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        
        int count=mp.size();
        int i=0,j=0;
        
        while(j<s2.length())
        {
            char ch=s2.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)-1);
            while(mp.get(ch)<0)
            {
                char c=s2.charAt(i);
                mp.put(c,mp.getOrDefault(c,0)+1);
                i++;
            }
            
            if(j-i+1==s1.length())
                return true;
            j++;
        }
        return false;
    }
}