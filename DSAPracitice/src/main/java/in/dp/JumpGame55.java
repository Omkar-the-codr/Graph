package in.dp;

import java.util.Arrays;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jump(nums, 0, dp);
    }
    public boolean jump(int[] nums, int i, int[] dp){
        if(i==nums.length-1) return true;
        if(dp[i]!=-1) return dp[i]==0?false:true;
        boolean ans = false;
        for(int j=1;j<=nums[i];j++){
            if(i+j<nums.length) ans = jump(nums, i+j, dp);
            if(ans) return true;
        }
        dp[i]= (ans==false?0:1);
        return ans;
    }
}
