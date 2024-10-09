class Twitter {
    
    class pair{
        int userId;
        int tweetId;
        int time;
        
        public pair(int userId, int tweetId, int time)
        {
            this.userId=userId;
            this.tweetId=tweetId;
            this.time=time;
        }
    }
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            return p2.time-p1.time;
        }
    }
    
    HashMap<Integer,HashSet<Integer>>mp;
    int curr=0;
    PriorityQueue<pair>pq;
    public Twitter() {
        mp=new HashMap<>();
        curr=0;
        pq=new PriorityQueue<>(new comp());
    }
    
    public void postTweet(int userId, int tweetId) {
        pq.add(new pair(userId,tweetId,curr));
        curr++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer>ans=new ArrayList<>();
        PriorityQueue<pair>user=new PriorityQueue<>(pq);
        int count=0;

        while(!user.isEmpty() && count<10)
        {
            pair top=user.poll();
            if(top.userId==userId || mp.containsKey(userId) && mp.get(userId).contains(top.userId))
            {
                ans.add(top.tweetId);
                count++;
            }
        }
        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!mp.containsKey(followerId))
            mp.put(followerId,new HashSet<Integer>());
        mp.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(mp.containsKey(followerId))
            mp.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */