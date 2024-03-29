package leetcode.top100.binarytree;

import xuefei.labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 19:32
 * @Version 1.0
 */
public class RightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
					res.add(node.val);
				}
			}
		}
		return res;
	}

}
