class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer>ansList=new ArrayList<>();
        int rowStart=0,rowEnd=m-1;
        int colStart=0,colEnd=n-1;
        
        while(colStart<=colEnd && rowStart<=rowEnd)
        {
            for(int i=colStart;i<=colEnd;i++)
                ansList.add(matrix[rowStart][i]);
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++)
                ansList.add(matrix[i][colEnd]);
            colEnd--;
            
            if(rowStart<=rowEnd)
            {
                for(int i=colEnd;i>=colStart;i--)
                    ansList.add(matrix[rowEnd][i]);
                rowEnd--;
            }
            
            if(colStart<=colEnd)
            {
                for(int i=rowEnd;i>=rowStart;i--)
                    ansList.add(matrix[i][colStart]);
                colStart++;
            }
        }
        
        return ansList;
    }
}