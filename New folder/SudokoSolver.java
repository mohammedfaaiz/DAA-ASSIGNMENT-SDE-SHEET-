import java.util.*;
public class Solution {
	public static boolean isItSudoku(int matrix[][]) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(matrix[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if(isValid(i,j,k,matrix)){
                            matrix[i][j]=k;
                            if(isItSudoku(matrix))
                                return true;
                            else
                                matrix[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
	} 
    public static boolean isValid(int row,int col,int num,int[][] matrix){
        for(int i=0;i<9;i++){
            if(col!=i && matrix[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(row!=i && matrix[i][col]==num){
                return false;
            }
        }
        int r = row - row%3;
        int c = col - col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(row!=i && col!=j && matrix[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}