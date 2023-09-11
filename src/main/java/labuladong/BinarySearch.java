package labuladong;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/7 10:49 AM
 * @Version 1.0
 */
public class BinarySearch {

	int binarySearch(int[] nums, int target) {
		// 一左一右两个指针相向而行
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			int mid = (right + left) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
		}
		return -1;
	}

}
