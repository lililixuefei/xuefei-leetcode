package leetcode.top100.dp;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/12/24 14:54
 * @Version 1.0
 */
public class ClimbStairs {

	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

}

