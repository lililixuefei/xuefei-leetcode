package lingcha;

import java.util.List;

/**
 * https://leetcode.cn/problems/apply-operations-on-array-to-maximize-sum-of-squares/solutions/2472120/ba-1-du-ju-zai-yi-qi-pythonjavacgo-by-en-rzng/
 *
 * @Description 对数组执行操作使平方和最大
 * @Author xuefei
 * @Date 2023/10/10 23:02
 * @Version 1.0
 */
public class MaxSum {

	public int maxSum(List<Integer> nums, int k) {
		final long MOD = 1_000_000_007;
		int[] cnt = new int[30];
		for (int x : nums) {
			for (int i = 0; i < 30; i++) {
				cnt[i] += (x >> i) & 1;
			}
		}
		long ans = 0;
		while (k-- > 0) {
			int x = 0;
			for (int i = 0; i < 30; i++) {
				if (cnt[i] > 0) {
					cnt[i]--;
					x |= 1 << i;
				}
			}
			ans = (ans + (long) x * x) % MOD;
		}
		return (int) ans;
	}

}
