package leetcode.basic.dfs;

import xuefei.labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 叶子相似的树
 * @author: xuefei
 * @date: 2023/04/20 23:27
 */
public class LeafSimilar {

	public static void main(String[] args) {
		List<Integer> seq1 = new ArrayList<>();
		List<Integer> seq2 = new ArrayList<>();

		seq1.add(11111);
		seq2.add(11111);
		System.out.println(seq1.equals(seq2));
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> seq1 = new ArrayList<>();
		if (root1 != null) {
			dfs(root1, seq1);
		}

		List<Integer> seq2 = new ArrayList<>();
		if (root2 != null) {
			dfs(root2, seq2);
		}

		return seq1.equals(seq2);
	}

	public void dfs(TreeNode node, List<Integer> seq) {
		if (node.left == null && node.right == null) {
			seq.add(node.val);
		} else {
			if (node.left != null) {
				dfs(node.left, seq);
			}
			if (node.right != null) {
				dfs(node.right, seq);
			}
		}
	}


}
