class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length())
            return false;
        if(s.equals(goal))
            return true;
        
        ArrayList<Character>list1=new ArrayList<>();
        ArrayList<Character>list2=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            list1.add(s.charAt(i));
            list2.add(goal.charAt(i));
        }
        
        for(int i=0;i<s.length();i++)
        {
            char first=list1.remove(0);
            list1.add(first);
            if(list1.equals(list2))
                return true;
        }
        return false;
        
    }
}