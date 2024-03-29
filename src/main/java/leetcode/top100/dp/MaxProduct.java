package leetcode.top100.dp;

/**
 * @Description 乘积最大子数组
 * @Author xuefei
 * @Date 2023/12/24 15:39
 * @Version 1.0
 */
public class MaxProduct {

	public int maxProduct2(int[] nums) {
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);

			max = Math.max(max, imax);
		}
		return max;
	}


	public int maxProduct(int[] nums) {
		int n = nums.length;
		// 定义：以 nums[i] 结尾的子数组，乘积最小为 dp1[i]
		int[] dp1 = new int[n];
		// 定义：以 nums[i] 结尾的子数组，乘积最大为 dp2[i]
		int[] dp2 = new int[n];
		// base case
		dp1[0] = nums[0];
		dp2[0] = nums[0];
		// 状态转移方程
		for (int i = 1; i < n; i++) {
			dp1[i] = min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
			dp2[i] = max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i], nums[i]);
		}
		// 遍历所有子数组的最大乘积，求最大值
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp2[i]);
		}
		return res;
	}

	int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

}
