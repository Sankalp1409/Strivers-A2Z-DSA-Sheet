class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuffer prefix=new StringBuffer();
        
        int index=-1;
        int len=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length()<len)
            {
                index=i;
                len=strs[i].length();
            }
        }
        
        String small=strs[index];
        // System.out.println(small);
        for(int i=0;i<small.length();i++)
        {
            char ch=small.charAt(i);
            boolean isMatch=true;
            for(int j=0;j<strs.length;j++)
            {
                if(j!=index && strs[j].charAt(i)!=ch)
                {
                    isMatch=false;
                    break;
                }
            }
            if(isMatch)
                prefix.append(ch+"");
            else
                break;
        }
        return prefix.toString();
    }
}