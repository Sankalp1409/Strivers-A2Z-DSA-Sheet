class Solution {

    public String formatString(String s)
    {
        StringBuilder newString=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
           if (s.charAt(i)>='A' && s.charAt(i)<='Z')
                newString.append((char)(s.charAt(i)+32));
            else if (s.charAt(i)>='a' && s.charAt(i)<='z' || (s.charAt(i)>='0' && s.charAt(i)<='9'))
                newString.append(s.charAt(i));
        }
        return newString.toString();
    }

    public boolean isPalindrome(String s) {
        
        String str=formatString(s);
        System.out.println("NEw String "+str);
        int i=0,j=str.length()-1;

        while(i<j)
        {
            if(str.charAt(i)==str.charAt(j))
            {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}