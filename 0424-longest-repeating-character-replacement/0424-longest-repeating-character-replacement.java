class Solution {
    public int characterReplacement(String s, int k) {
        
        int []count=new int[26];
        int i=0,j=0;
        int maxFreq=0;
        int len=0;
        while(j<s.length())
        {
            char ch=s.charAt(j);
            count[ch-'A']++;
            maxFreq=Math.max(maxFreq,count[ch-'A']);
            
            if((j-i+1)-maxFreq>k)
            {
                count[s.charAt(i)-'A']--;
                i++;
            }
            if((j-i+1)-maxFreq<=k)
                len=Math.max(j-i+1,len);
            j++;
        }
        return len;
    }
}