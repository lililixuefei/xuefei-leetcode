package leetcode.daily;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 优势洗牌
 * @author: xuefei
 * @date: 2023/04/05 18:30
 */
public class AdvantageCount {

	public int[] advantageCount(int[] nums1, int[] nums2) {
		int n = nums1.length;
		// 给 nums2 降序排序
		PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
			return pair2[1] - pair1[1];
		});
		for (int i = 0; i < n; i++) {
			maxpq.offer(new int[]{i, nums2[i]});
		}
		// 给 nums1 升序排序
		Arrays.sort(nums1);

		// nums1[left] 是最小值，nums1[right] 是最大值
		int left = 0, right = n - 1;
		int[] res = new int[n];

		while (!maxpq.isEmpty()) {
			int[] pair = maxpq.poll();
			// maxVal 是 nums2 中的最大值，i 是对应索引
			int i = pair[0];
			int maxVal = pair[1];
			if (maxVal < nums1[right]) {
				// 如果 nums1[right] 能胜过 maxVal，那就自己上
				res[i] = nums1[right];
				right--;
			} else {
				// 否则用最小值混一下，养精蓄锐
				res[i] = nums1[left];
				left++;
			}
		}
		return res;
	}

}
