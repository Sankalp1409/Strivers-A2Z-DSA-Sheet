class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix="";
        int index=-1;
        int len=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length()<len)
            {
                len=strs[i].length();
                index=i;
            }
        }
        for(int i=0;i<strs[index].length();i++)
        {
            char ch=strs[index].charAt(i);
            for(int j=0;j<strs.length;j++)
            {
                if(j!=index && ch!=strs[j].charAt(i))
                    return prefix;
            }
            prefix+=ch;
        }
        return prefix;
    }
}