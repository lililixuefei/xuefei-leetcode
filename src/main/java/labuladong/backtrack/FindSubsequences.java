package labuladong.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/26 4:19 PM
 * @Version 1.0
 */
public class FindSubsequences {

	List<List<Integer>> result = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		backTracking(nums, 0);
		return result;
	}

	private void backTracking(int[] nums, int startIndex) {
		if (path.size() >= 2) {
			result.add(new ArrayList<>(path));
		}
		Set<Integer> hs = new HashSet<>();
		for (int i = startIndex; i < nums.length; i++) {
			if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || hs.contains(nums[i])) {
				continue;
			}
			hs.add(nums[i]);
			path.add(nums[i]);
			backTracking(nums, i + 1);
			path.remove(path.size() - 1);
		}
	}

}
