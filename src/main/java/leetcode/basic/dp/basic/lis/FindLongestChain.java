package leetcode.basic.dp.basic.lis;

import java.util.Arrays;

/**
 * @description: 最长数对链
 * @author: xuefei
 * @date: 2023/06/08 22:46
 */
public class FindLongestChain {

	public int findLongestChain(int[][] pairs) {
		int n = pairs.length;
		Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[i][0] > pairs[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n - 1];
	}

	public int findLongestChain_2(int[][] pairs) {
		int curr = Integer.MIN_VALUE;
		int res = 0;
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
		for (int[] p : pairs) {
			if (curr < p[0]) {
				curr = p[1];
				res++;
			}
		}
		return res;
	}


}
