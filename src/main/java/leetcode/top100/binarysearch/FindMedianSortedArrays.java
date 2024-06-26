package leetcode.top100.binarysearch;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:14
 * @Version 1.0
 */
public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		//将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		//让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (len1 > len2) {
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		}
		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
		} else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
		}
	}


	/**
	 * O(m+n)
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArraysWay2(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int len = m + n;
		int left = -1, right = -1;
		int aStart = 0, bStart = 0;
		for (int i = 0; i <= len / 2; i++) {
			left = right;
			if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
				right = nums1[aStart++];
			} else {
				right = nums2[bStart++];
			}
		}
		if ((len & 1) == 0) {
			return (left + right) / 2.0;
		} else {
			return right;
		}
	}

	/**
	 * 解法一：简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
	 * O(m+n)
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArraysWay1(int[] nums1, int[] nums2) {
		int[] nums;
		int m = nums1.length;
		int n = nums2.length;
		nums = new int[m + n];
		if (m == 0) {
			if (n % 2 == 0) {
				return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
			} else {
				return nums2[n / 2];
			}
		}
		if (n == 0) {
			if (m % 2 == 0) {
				return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		}

		int count = 0;
		int i = 0, j = 0;
		while (count != (m + n)) {
			if (i == m) {
				while (j != n) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			if (j == n) {
				while (i != m) {
					nums[count++] = nums1[i++];
				}
				break;
			}

			if (nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			} else {
				nums[count++] = nums2[j++];
			}
		}

		if (count % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		} else {
			return nums[count / 2];
		}
	}
}
