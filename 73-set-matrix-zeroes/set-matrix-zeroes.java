class Solution {
    public void setZeroes(int[][] matrix) {
        int col0=1;
        int n=matrix.length;
        int m=matrix[0].length;
        
        // marking zero row & col
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(j==0)
                        col0=0;
                    else
                        matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        // making non-zero to zero based on above marking
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]!=0)
                {
                    if(matrix[0][j]==0 || matrix[i][0]==0)
                        matrix[i][j]=0;
                }
            }
        }

        // handling 0th row
        for(int j=m-1;j>=0;j--)
        {
            if(matrix[0][j]!=0 && matrix[0][0]==0)
                matrix[0][j]=0;
        }

        // handling 0th col using col0 variable
        for(int i=n-1;i>=0;i--)
        {
            if(matrix[i][0]!=0 && col0==0)
                matrix[i][0]=0;
        }
    }
}