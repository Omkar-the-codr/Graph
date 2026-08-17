package in.dp;

import java.util.Arrays;

public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int[] ele: dp){
            Arrays.fill(ele, -1);
        }
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        return unique(obstacleGrid.length-1, obstacleGrid[0].length-1, obstacleGrid, dp);
    }
    public int unique(int m, int n, int[][] obstacleGrid, int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int down = 0;
        int right =0;
        if(m-1>=0 && obstacleGrid[m-1][n]!=1) down+= unique(m-1, n, obstacleGrid, dp);
        if(n-1>=0 && obstacleGrid[m][n-1]!=1) right+= unique(m, n-1, obstacleGrid, dp);
        return dp[m][n]=down+right;
    }
}
