class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer>ansList=new ArrayList<>();
        int rowStart=0;
        int rowEnd=n-1;
        int colStart=0;
        int colEnd=m-1;

        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            for(int j=colStart;j<=colEnd;j++)
            {
                ansList.add(matrix[rowStart][j]);
            }
            rowStart++;

            for(int i=rowStart;i<=rowEnd;i++)
            {
                ansList.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowStart<=rowEnd)
            {
                for(int j=colEnd;j>=colStart;j--)
                {
                    ansList.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            if(colStart<=colEnd)
            {
                for(int i=rowEnd;i>=rowStart;i--)
                {
                    ansList.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }

        return ansList;
    }
}