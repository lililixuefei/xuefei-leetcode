package leetcode.daily;


/**
 * @description: 删除最短的子数组使剩余数组有序
 * @author: xuefei
 * @date: 2023/03/25 22:00
 */
public class FindLengthOfShortestSubarray {

	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length;
		int j = n - 1;
		while (j > 0 && arr[j - 1] <= arr[j]) {
			j--;
		}
		if (j == 0) {
			return 0;
		}
		int res = j;
		for (int i = 0; i < n; i++) {
			while (j < n && arr[j] < arr[i]) {
				j++;
			}
			res = Math.min(res, j - i - 1);
			if (i + 1 < n && arr[i] > arr[i + 1]) {
				break;
			}
		}
		return res;
	}
}