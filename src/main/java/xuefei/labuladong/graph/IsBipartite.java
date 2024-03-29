package xuefei.labuladong.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 判断二分图
 * @author: xuefei
 * @date: 2023/04/16 16:09
 */
public class IsBipartite {

	// 记录图是否符合二分图性质
	private boolean ok = true;
	// 记录图中节点的颜色，false 和 true 代表两种不同颜色
	private boolean[] color;
	// 记录图中节点是否被访问过
	private boolean[] visited;

	// 主函数，输入邻接表，判断是否是二分图
	public boolean isBipartite_dfs(int[][] graph) {
		int n = graph.length;
		color = new boolean[n];
		visited = new boolean[n];
		// 因为图不一定是联通的，可能存在多个子图
		// 所以要把每个节点都作为起点进行一次遍历
		// 如果发现任何一个子图不是二分图，整幅图都不算二分图
		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				traverse(graph, v);
			}
		}
		return ok;
	}

	// DFS 遍历框架
	private void traverse(int[][] graph, int v) {
		// 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
		if (!ok) {
			return;
		}

		visited[v] = true;
		for (int w : graph[v]) {
			if (!visited[w]) {
				// 相邻节点 w 没有被访问过
				// 那么应该给节点 w 涂上和节点 v 不同的颜色
				color[w] = !color[v];
				// 继续遍历 w
				traverse(graph, w);
			} else {
				// 相邻节点 w 已经被访问过
				// 根据 v 和 w 的颜色判断是否是二分图
				if (color[w] == color[v]) {
					// 若相同，则此图不是二分图
					ok = false;
				}
			}
		}
	}


	/*BFS*/
	public boolean isBipartite_bfs(int[][] graph) {
		int n = graph.length;
		color = new boolean[n];
		visited = new boolean[n];

		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				// 改为使用 BFS 函数
				bfs(graph, v);
			}
		}

		return ok;
	}

	// 从 start 节点开始进行 BFS 遍历
	private void bfs(int[][] graph, int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty() && ok) {
			int v = q.poll();
			// 从节点 v 向所有相邻节点扩散
			for (int w : graph[v]) {
				if (!visited[w]) {
					// 相邻节点 w 没有被访问过
					// 那么应该给节点 w 涂上和节点 v 不同的颜色
					color[w] = !color[v];
					// 标记 w 节点，并放入队列
					visited[w] = true;
					q.offer(w);
				} else {
					// 相邻节点 w 已经被访问过
					// 根据 v 和 w 的颜色判断是否是二分图
					if (color[w] == color[v]) {
						// 若相同，则此图不是二分图
						ok = false;
					}
				}
			}
		}
	}

}
