package xuefei.done.leetcode.everyday;

/**
 * @description: 判断子序列   https://leetcode.cn/problems/is-subsequence/
 * @author: xuefei
 * @date: 2022/06/28 22:36
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
