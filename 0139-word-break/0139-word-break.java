class Solution {
    HashMap<Integer,Boolean>mp=new HashMap<>();
    public boolean solve(String s, int idx, List<String> wordDict)
    {
        if(idx==s.length())
            return true;
        
        if(mp.containsKey(idx))
            return mp.get(idx);
        
        for(int i=idx;i<s.length();i++)
        {
            String str=s.substring(idx,i+1);
            if(wordDict.contains(str))
            {
                if(solve(s,i+1,wordDict))
                {
                    mp.put(idx,true);
                    return true;
                }
            }
        }
        mp.put(idx,false);
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s,0,wordDict);
    }
}