class Solution {
    
    public int findMaxElementRow(int mat[][], int mid)
    {
        int maxi=Integer.MIN_VALUE;
        int row=0;
        for(int i=0;i<mat.length;i++)
        {
            if(mat[i][mid] > maxi)
            {
                maxi=mat[i][mid];
                row=i;
            }
        }
        return row;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        
        int low=0;
        int high=mat[0].length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            int maxEleRow=findMaxElementRow(mat,mid);
            
            int left= mid==0 ? -1 : mat[maxEleRow][mid-1];
            int right= mid==mat[0].length-1 ? -1 : mat[maxEleRow][mid+1];
            int curr=mat[maxEleRow][mid];
            if(curr > left && curr > right)
                return new int []{maxEleRow,mid};
            else if(left > curr)
                high=mid-1;
            else
                low=mid+1;
        }
        return new int []{-1,-1};
    }
}