package labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/9 7:48 下午
 * @Version 1.0
 */
public class Permute2 {

	static List<List<Integer>> res = new LinkedList<>();
	// 记录回溯算法的递归路径
	static LinkedList<Integer> track = new LinkedList<>();
	// track 中的元素会被标记为 true
	static boolean[] used;

	/* 主函数，输入一组不重复的数字，返回它们的全排列 */
	public static List<List<Integer>> permute(int[] nums) {
		used = new boolean[nums.length];
		backtrack(nums);
		return res;
	}


	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		List<List<Integer>> permute = permute(nums);
		for (List<Integer> list : permute) {
			System.out.println(list);
		}
	}

	// 回溯算法核心函数
	static void backtrack(int[] nums) {
		// base case，到达叶子节点
		if (track.size() == nums.length) {
			// 收集叶子节点上的值
			res.add(new LinkedList(track));
			return;
		}

		// 回溯算法标准框架
		for (int i = 0; i < nums.length; i++) {
			// 已经存在 track 中的元素，不能重复选择
			if (used[i]) {
				continue;
			}
			// 做选择
			used[i] = true;
			track.addLast(nums[i]);
			// 进入下一层回溯树
			backtrack(nums);
			// 取消选择
			track.removeLast();
			used[i] = false;
		}
	}

}
