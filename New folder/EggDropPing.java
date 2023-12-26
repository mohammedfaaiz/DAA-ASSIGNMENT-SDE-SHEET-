public class Solution {
    int min = 0;
    public static int cutLogs(int k, int n) {
        if(k==1)
            return n;
        
        int dp[] = new int[k + 1], m = 0;
        for (m = 0; dp[k] < n; ++m)
            for (int kk = k; kk > 0; --kk)
                dp[kk] += dp[kk - 1] + 1;
        return m;
    }
}