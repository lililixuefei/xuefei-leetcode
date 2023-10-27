package leetcode.top100.undo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 矩阵置零
 * @Author xuefei
 * @Date 2023/10/27 22:57
 * @Version 1.0
 */
public class SetZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    int[] ans = new int[]{i, j};
                    list.add(ans);
                }
            }
        }

        for (int[] ans : list) {
            setZero(matrix, ans[0], ans[1]);
        }
    }

    private static void setZero(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i1 = 0; i1 < col; i1++) {
            matrix[i][i1] = 0;
        }
        for (int i1 = 0; i1 < row; i1++) {
            matrix[i1][j] = 0;
        }
    }

}
