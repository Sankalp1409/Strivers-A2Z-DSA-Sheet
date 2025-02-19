class Solution {
    class custom{
        String word;
        int length;

        public custom(String word, int length)
        {
            this.word=word;
            this.length=length;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String>hs=new HashSet<>();
        for(String s:wordList)
            hs.add(s);
        
        Queue<custom>q=new LinkedList<>();
        q.add(new custom(beginWord,1));
        while(!q.isEmpty())
        {
            custom front=q.poll();
            String word=front.word;
            int length=front.length;
            if(word.equals(endWord))
                return length;

            StringBuffer sb=new StringBuffer(word);
            for(int i=0;i<word.length();i++)
            {
                char letter=word.charAt(i);
                for(char ch='a';ch<='z';ch++)
                {
                    sb.setCharAt(i,ch);
                    // System.out.println(sb.toString());
                    if(hs.contains(sb.toString()))
                    {
                        hs.remove(sb.toString());
                        q.add(new custom(sb.toString(),length+1));
                    }
                }
                sb.setCharAt(i,letter);
            }
        }
        return 0;
    }
}