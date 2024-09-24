class Solution {
    
    public boolean isPalindrome(String s)
    {
        int left=0,right=s.length()-1;
        
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    public void solve(String s, int idx,List<String>temp,List<List<String>>ansList)
    {
        if(idx==s.length())
        {
            ansList.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s.substring(idx,i+1)))
            {
                temp.add(s.substring(idx,i+1));
                solve(s,i+1,temp,ansList);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        
        List<List<String>>ansList=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        
        solve(s,0,temp,ansList);
        return ansList;
        
    }
}