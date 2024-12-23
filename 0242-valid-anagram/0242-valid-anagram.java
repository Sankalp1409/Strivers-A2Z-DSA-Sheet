class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            if(mp.containsKey(ch))
            {
                if(mp.get(ch)==1)
                    mp.remove(ch);
                else
                    mp.put(ch,mp.get(ch)-1);
            }
            else
                return false;
        }
        return mp.isEmpty();
    }
}