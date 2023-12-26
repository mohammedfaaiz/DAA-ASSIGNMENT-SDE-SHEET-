import java.util.*;

public class Solution {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        n++;
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(matrix[i],1000000000);
            matrix[i][i] = 0;
        }
        for(ArrayList<Integer> edge : edges){
            matrix[edge.get(0)][edge.get(1)] = edge.get(2);
        }
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j];
            }
        }
        
        // Compute all pairs shortest paths.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        
        return dp[src][dest]>100000?1000000000:dp[src][dest];
    }

}