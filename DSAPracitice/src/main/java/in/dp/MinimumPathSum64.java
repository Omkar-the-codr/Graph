package in.dp;

import java.util.Arrays;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return minSum(grid, grid.length-1, grid[0].length-1, dp);
    }
    public int minSum(int[][] grid, int m, int n, int[][] dp){
        if(m==0 && n==0) return grid[0][0];
        if(dp[m][n]!=-1) return dp[m][n];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(m>0) up = grid[m][n]+minSum(grid, m-1, n, dp);
        if(n>0) left = grid[m][n] + minSum(grid, m, n-1, dp);
        return dp[m][n]=Math.min(up, left);
    }
}
