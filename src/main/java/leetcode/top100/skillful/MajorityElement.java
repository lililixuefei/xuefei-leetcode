package leetcode.top100.skillful;

import java.util.Arrays;

/**
 * @Description 多数元素
 * @Author xuefei
 * @Date 2024/3/24 19:58
 * @Version 1.0
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		// 我们想寻找的那个众数
		int target = 0;
		// 计数器（类比带电粒子例子中的带电性）
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				// 当计数器为 0 时，假设 nums[i] 就是众数
				target = nums[i];
				// 众数出现了一次
				count = 1;
			} else if (nums[i] == target) {
				// 如果遇到的是目标众数，计数器累加
				count++;
			} else {
				// 如果遇到的不是目标众数，计数器递减
				count--;
			}
		}
		// 回想带电粒子的例子
		// 此时的 count 必然大于 0，此时的 target 必然就是目标众数
		return target;
	}

	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}


}
