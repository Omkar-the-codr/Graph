package in.dp;

import java.util.Arrays;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return recur(dp, n);
    }
    public int recur(int[] dp, int n){
        if(n==0) return 1;
        else if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int one = climbStairs(n-1);
        int two = climbStairs(n-2);
        return dp[n] = one+two;
    }
}
