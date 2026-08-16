package in.dp;

import java.util.Arrays;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] ele: dp){
            Arrays.fill(ele, -1);
        }
        return unique(m, n, dp);
    }
    public int unique(int m, int n, int[][] dp){
        if(m==1 && n==1) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int down = 0;
        int right =0;
        down+= unique(m-1, n, dp);
        right+= unique(m, n-1, dp);
        return dp[m][n]=down+right;
    }
}
