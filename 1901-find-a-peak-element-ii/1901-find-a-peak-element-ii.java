class Solution {
    
    public int solve(int []arr)
    {
        int index=0;
        int maxi=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>maxi)
            {
                maxi=arr[i];
                index=i;
            }
        }
        return index;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        
        int low=0,high=mat.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            int idx=solve(mat[mid]);
            System.out.println(idx);
            
            int up= mid-1>=0 ? mat[mid-1][idx]:-1;
            int down= mid+1<mat.length ? mat[mid+1][idx]:-1;
            
            if(mat[mid][idx] > up && mat[mid][idx]>down)
                return new int []{mid,idx};
            else if(up > mat[mid][idx])
                high=mid-1;
            else
                low=mid+1;
        }
        return new int[]{-1,-1};
    }
}