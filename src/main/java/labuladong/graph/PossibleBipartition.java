package labuladong.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/18 8:11 PM
 * @Version 1.0
 */
public class PossibleBipartition {

	private boolean ok = true;
	private boolean[] color;
	private boolean[] visited;

	public boolean possibleBipartition(int n, int[][] dislikes) {
		// 图节点编号为 1...n
		color = new boolean[n + 1];
		visited = new boolean[n + 1];
		// 转化成邻接表表示图结构
		List<Integer>[] graph = buildGraph(n, dislikes);

		for (int v = 1; v <= n; v++) {
			if (!visited[v]) {
				traverse(graph, v);
			}
		}

		return ok;
	}

	// 建图函数
	private List<Integer>[] buildGraph(int n, int[][] dislikes) {
		// 图节点编号为 1...n
		List<Integer>[] graph = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : dislikes) {
			int v = edge[1];
			int w = edge[0];
			// 「无向图」相当于「双向图」
			// v -> w
			graph[v].add(w);
			// w -> v
			graph[w].add(v);
		}
		return graph;
	}

	// 和之前的 traverse 函数完全相同
	private void traverse(List<Integer>[] graph, int v) {
		if (!ok) {
			return;
		}
		visited[v] = true;
		for (int w : graph[v]) {
			if (!visited[w]) {
				color[w] = !color[v];
				traverse(graph, w);
			} else {
				if (color[w] == color[v]) {
					ok = false;
				}
			}
		}
	}

}
