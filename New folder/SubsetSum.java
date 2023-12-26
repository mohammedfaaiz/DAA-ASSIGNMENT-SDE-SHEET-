public class Solution {
    static boolean found = false;
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        found = false;
        fn(k,arr,0,dp);
        return found;
    }
    public static void fn(int k,int[] arr,int index,int[][] dp){
        if(k==0){
            found = true;
            return ;
        }
        if(k<0)
            return;
        if(index==arr.length){
            return ;
        }
        if(dp[index][k]!=0)
            return;
        
        if(!found){
            fn(k - arr[index],arr,index + 1,dp);
        }
        if(!found){
            fn(k,arr,index + 1,dp);
        }
        
        dp[index][k] = -1;
        
        return;
    } 
}