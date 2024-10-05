class Solution {
    public int countGoodSubstrings(String s) {
        
        int ans=0;
        int []count=new int[26];
        int i=0,j=0;
        
        while(j<s.length())
        {
            count[s.charAt(j)-'a']++;
            
            if(j-i+1==3)
            {
                if(isEqual(count)) ans++;
                count[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
    
    public boolean isEqual(int []arr)
    {
        for(int i:arr)
            if(i>1) return false;
        return true;
    }
}