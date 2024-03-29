package labuladong.array;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/7 10:47 AM
 * @Version 1.0
 */
public class MoveZeroes {

	void moveZeroes(int[] nums) {
		// 去除 nums 中的所有 0，返回不含 0 的数组长度
		int p = removeElement(nums, 0);
		// 将 nums[p..] 的元素赋值为 0
		for (; p < nums.length; p++) {
			nums[p] = 0;
		}
	}

	int removeElement(int[] nums, int val) {
		int fast = 0, slow = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}

}
