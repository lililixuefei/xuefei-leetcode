package leetcode.basic.binarytree.bst;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/20 23:15
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}