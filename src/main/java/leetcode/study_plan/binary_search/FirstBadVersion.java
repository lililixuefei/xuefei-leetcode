package leetcode.study_plan.binary_search;

/**
 * @description: 第一个错误的版本  https://leetcode.cn/problems/first-bad-version/
 * @author: xuefei
 * @date: 2022/05/18 23:47
 */
public class FirstBadVersion {

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


    boolean isBadVersion(int version) {
        return false;
    }
}
