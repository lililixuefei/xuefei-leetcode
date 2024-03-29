package labuladong.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/17 7:47 PM
 * @Version 1.0
 */
public class AllPathsSourceTarget {

	public static void main(String[] args) {
		AllPathsSourceTarget all = new AllPathsSourceTarget();

		int[][] graph = {{1, 2}, {3}, {3}, {}};

		all.allPathsSourceTarget(graph);
	}

	// 记录所有路径
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		// 维护递归过程中经过的路径
		LinkedList<Integer> path = new LinkedList<>();
		traverse(graph, 0, path);
		return res;
	}

	/* 图的遍历框架 */
	void traverse(int[][] graph, int s, LinkedList<Integer> path) {
		// 添加节点 s 到路径
		path.addLast(s);
		if (s == graph.length - 1) {
			// 到达终点
			res.add(new LinkedList<>(path));
			path.removeLast();
			return;
		}
		// 递归每个相邻节点
		for (int v : graph[s]) {
			traverse(graph, v, path);
		}
		// 从路径移出节点 s
		path.removeLast();
	}

}
