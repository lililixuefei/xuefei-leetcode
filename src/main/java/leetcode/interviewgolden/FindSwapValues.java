package leetcode.interviewgolden;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 交换和
 * @author: xuefei
 * @date: 2023/04/01 21:50
 */
public class FindSwapValues {

	public int[] findSwapValues(int[] array1, int[] array2) {
		// 记录两个数组的和
		int sum1 = 0;
		int sum2 = 0;
		// 记录 array2 中的数都出现过哪些
		Set<Integer> container = new HashSet<>();
		for (int num : array1) {
			sum1 += num;
		}
		for (int num : array2) {
			container.add(num);
			sum2 += num;
		}
		// 求两个数组之差
		int diff = sum1 - sum2;
		// 如果不是偶数差值，那么直接返回空数组
		if (diff % 2 != 0) {
			return new int[]{};
		}
		diff /= 2;
		// 从 array2 中找到能和 array1 中 num 配对的数，如果找到了就直接返回，没找到就返回空数组。
		for (int num : array1) {
			if (container.contains(num - diff)) {
				return new int[]{num, num - diff};
			}
		}
		return new int[]{};
	}

}
