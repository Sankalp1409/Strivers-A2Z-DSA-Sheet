class Solution {
    
    class pair{
        char c;
        int freq;
        public pair(char c, int freq)
        {
            this.c=c;
            this.freq=freq;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair other = (pair) o;
            return c == other.c && freq == other.freq;
        }

        @Override
        public int hashCode() {
            return 31 * c + freq; // Combine the hash of `c` and `freq`
        }
    }
    
    public int maximumLength(String s) {
        
        Map<pair,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int length=0;
            char curr=s.charAt(i);
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(j)==curr)
                    length++;
                else
                    break;
                pair p=new pair(curr,length);
                mp.put(p,mp.getOrDefault(p,0)+1);
            }
        }
        // System.out.println(mp);
        int len=-1;
        for(Map.Entry<pair,Integer>e:mp.entrySet())
        {
            if(e.getValue()>=3)
                len=Math.max(len,e.getKey().freq);
            // System.out.println(e.getKey().c);
        }
        return len;
    }
}