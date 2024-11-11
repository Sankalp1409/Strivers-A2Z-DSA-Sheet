class Solution {
    public int compress(char[] chars) {
        
        int count=1;
        int len=0;
        int idx=0;
        for(int i=1;i<chars.length;i++)
        {
            if(chars[i-1]==chars[i])
            {
                count++;
            }
            else
            {
                len++;
                if(count>1)
                {
                    chars[idx++]=chars[i-1];
                    String num=String.valueOf(count);
                    for(int j=0;j<num.length();j++)
                    {
                        chars[idx++]=num.charAt(j);
                        len++;
                    }
                }
                else
                    chars[idx++]=chars[i-1];
                count=1;
            }
        }
        len++;
        if(count>1)
        {
            chars[idx++]=chars[chars.length-1];
            String num=String.valueOf(count);
            for(int i=0;i<num.length();i++)
            {
                chars[idx++]=num.charAt(i);
                len++;
            }
        }
        else
            chars[idx++]=chars[chars.length-1];
        return len;
    }
}