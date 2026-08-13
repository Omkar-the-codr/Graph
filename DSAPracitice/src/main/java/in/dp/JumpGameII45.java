package in.dp;

import java.util.Arrays;

public class JumpGameII45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recurse(nums, 0, dp);
    }
    public int recurse(int[] nums, int i, int[] dp){
        if(i==nums.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int numOfjumps = Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            if(i+j<nums.length){
                int jumps= recurse(nums, i+j, dp);
                if(jumps!=Integer.MAX_VALUE){
                    numOfjumps = Math.min(numOfjumps, 1+ jumps);
                }
            }
        }
        return dp[i]=numOfjumps;
    }
}
