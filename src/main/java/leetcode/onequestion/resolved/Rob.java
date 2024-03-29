package leetcode.onequestion.resolved;

/**
 * @Description 打家劫舍
 * @Author xuefei
 * @Date 2023/9/16 0:01
 * @Version 1.0
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((nums[i] + dp[i - 2]), dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
