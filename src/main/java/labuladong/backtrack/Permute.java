package labuladong.backtrack;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/20 7:27 PM
 * @Version 1.0
 */
public class Permute {


	static List<List<Integer>> res = new LinkedList<>();


	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> permute = permute(nums);

		for (List<Integer> integers : permute) {
			String res = StringUtils.join(integers, ",");
			System.out.println(res);
		}
	}

	/* 主函数，输入一组不重复的数字，返回它们的全排列 */
	static List<List<Integer>> permute(int[] nums) {
		// 记录「路径」
		LinkedList<Integer> track = new LinkedList<>();
		backtrack(nums, track);
		return res;
	}

	// 路径：记录在 track 中
	// 选择列表：nums 中不存在于 track 的那些元素
	// 结束条件：nums 中的元素全都在 track 中出现
	static void backtrack(int[] nums, LinkedList<Integer> track) {
		// 触发结束条件
		if (track.size() == nums.length) {
			res.add(new LinkedList(track));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			// 排除不合法的选择
			if (track.contains(nums[i])) {
				continue;
			}
			// 做选择
			track.add(nums[i]);
			// 进入下一层决策树
			backtrack(nums, track);
			// 取消选择
			track.removeLast();
		}
	}
}
