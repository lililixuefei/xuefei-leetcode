package leetcode.basic.dfs;

/**
 * @description: 飞地的数量
 * @author: xuefei
 * @date: 2023/03/29 23:21
 */
public class NumEnclaves {

	public int numEnclaves(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < n; i++) {
			dfs(grid, i, 0);
			dfs(grid, i, m - 1);
		}

		for (int j = 0; j < m; j++) {
			dfs(grid, 0, j);
			dfs(grid, n - 1, j);
		}

		int lands = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					lands++;
				}
			}
		}
		return lands;
	}

	private void dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

}
