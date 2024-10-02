class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        
        int windowSize=cardPoints.length-k;
        int totalSum=0;
        for(int i:cardPoints)
            totalSum+=i;
        
        if(k==cardPoints.length)
            return totalSum;
        
        int i=0,j=0;
        int maxi=0,sum=0;
        while(j<cardPoints.length)
        {
            sum+=cardPoints[j];
            if(j-i+1==windowSize)
            {
                maxi=Math.max(maxi,totalSum-sum);
                sum-=cardPoints[i];
                i++;
            }
            j++;
        }
        return maxi;
    }
}