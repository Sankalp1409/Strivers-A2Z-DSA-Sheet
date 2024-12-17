class Solution {
    
    class pair{
        char ch;
        int freq;
        
        public pair(char ch, int freq)
        {
            this.ch=ch;
            this.freq=freq;
        }
    }
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            return p2.ch-p1.ch;
        }
    }
    
    public void solve(StringBuffer str, char ch , int freq)
    {
        for(int i=0;i<freq;i++)
            str.append(ch+"");
    }
    
    public String repeatLimitedString(String s, int repeatLimit) {
        
        PriorityQueue<pair> pq=new PriorityQueue<>(new comp());
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        
        for(Map.Entry<Character,Integer>e:mp.entrySet())
            pq.add(new pair(e.getKey(),e.getValue()));
        
        StringBuffer ansStr=new StringBuffer();
        
        while(!pq.isEmpty())
        {
            pair top=pq.poll();
            if(top.freq<=repeatLimit)
                solve(ansStr,top.ch,top.freq);
            else
            {
                solve(ansStr,top.ch,repeatLimit);
                top.freq-=repeatLimit;
                if(pq.size()>0)
                {
                    pair secondTop=pq.poll();
                    ansStr.append(secondTop.ch);
                    secondTop.freq--;
                    if(secondTop.freq>0)
                        pq.add(secondTop);
                    pq.add(top);
                }
                else
                    break;
            }
        }
        
        return ansStr.toString();
    }
}