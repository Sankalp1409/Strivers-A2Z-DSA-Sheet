class Pair{
    char ch;
    int freq;
    
    public Pair(char ch, int freq)
    {
        this.ch=ch;
        this.freq=freq;
    }
}

class comp implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2)
    {
        return p2.freq-p1.freq;
    }
}

class Solution {
    
    
    public String frequencySort(String s) {
        
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        
        List<Pair>list=new ArrayList<>();
        for(Map.Entry<Character,Integer>e:mp.entrySet())
        {
            list.add(new Pair(e.getKey(),e.getValue()));
        }
        
        Collections.sort(list,new comp());
        
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).freq;j++)
                sb.append(list.get(i).ch);
        }
        return sb.toString();
    }
}