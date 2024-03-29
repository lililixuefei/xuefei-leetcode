package leetcode.top100.array;

/**
 * @Description 轮转数组
 * @Author xuefei
 * @Date 2024/3/24 19:41
 * @Version 1.0
 */
public class Rotate {

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int[] newArr = new int[n];
		for (int i = 0; i < n; ++i) {
			newArr[(i + k) % n] = nums[i];
		}
		System.arraycopy(newArr, 0, nums, 0, n);
	}


	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start += 1;
			end -= 1;
		}
	}

}
