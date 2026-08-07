package in.dp;

import java.util.Arrays;

public class NthTribonacciNumber1137 {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return tribo(n, dp);
    }
    public int tribo(int n, int[] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans = tribo(n-3, dp) + tribo(n-1, dp) + tribo(n-2, dp);
        return dp[n]=ans;
    }
}
