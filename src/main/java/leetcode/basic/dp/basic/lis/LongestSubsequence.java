package leetcode.basic.dp.basic.lis;

import java.util.Arrays;

/**
 * @description: 最长定差子序列
 * @author: xuefei
 * @date: 2023/06/08 22:59
 */
public class LongestSubsequence {


	public int longestSubsequence(int[] arr, int difference) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] - arr[j] == difference) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(dp[i], res);
				}
			}
		}
		return res;
	}

}