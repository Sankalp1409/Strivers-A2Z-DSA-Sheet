class Solution {
    
    public void solve(String digit, int idx, String temp,List<String>ansList,String []mapping)
    {
        if(idx==digit.length())
        {
            ansList.add(temp);
            return;
        }
        
        int value=digit.charAt(idx)-'0';
        
        String letter=mapping[value];
        for(int i=0;i<letter.length();i++)
            solve(digit,idx+1,temp+letter.charAt(i),ansList,mapping);
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return new ArrayList<>();
        String []mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>ansList=new ArrayList<>();
        String temp="";
        solve(digits,0,temp,ansList,mapping);
        return ansList;
        
    }
}