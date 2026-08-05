package in.dp;

import java.util.Arrays;

public class MinCostClimbing746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(cost[0]+dp(cost, 0, dp), cost[1]+dp(cost,1, dp));
    }
    public int dp(int[] cost, int i, int[] dp){
        if(i==cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int one = 0;
        if(i<cost.length-1) one = cost[i+1] + dp(cost, i+1, dp);
        int two = 0;
        if(i<cost.length-2){
            two = cost[i+2] + dp(cost, i+2, dp);
        }
        return dp[i] = Math.min(one, two);
    }
}
