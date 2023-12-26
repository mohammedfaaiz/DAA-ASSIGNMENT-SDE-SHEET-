public class Solution 
{
    public static int getTotalIslands(int[][] mat) 
	{
        int countIslands = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    fn(mat,i,j);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
    public static void fn(int[][] mat,int row,int col){
        if(row<0 || row>=mat.length || col<0 || col>=mat[0].length || mat[row][col]==0){
            return ;
        }
        
        mat[row][col] = 0;
        
        fn(mat,row-1,col);
        fn(mat,row+1,col);
        fn(mat,row,col-1);
        fn(mat,row,col+1);
        fn(mat,row+1,col+1);
        fn(mat,row+1,col-1);
        fn(mat,row-1,col+1);
        fn(mat,row-1,col-1);
    }
}