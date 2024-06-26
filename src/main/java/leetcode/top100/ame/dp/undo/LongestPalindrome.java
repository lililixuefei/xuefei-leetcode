package leetcode.top100.ame.dp.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/6 17:13
 * @Version 1.0
 */
public class LongestPalindrome {

	public String longestPalindrome2(String s) {
		// 获取字符串 s 的长度
		int length = s.length();
		// 设置数组 dp，用来存储字符串 s 的 [i,j] 区间的子串是否是回文子串
		// dp[0][0] 表示字符串 s 第 0 个字符和字符串 s 第 0 个字符之间的子串是否是回文子串
		// dp[2][3] 表示字符串 s 第 2 个字符和字符串 s 第 3 个字符之间的子串是否是回文子串
		// dp[i][j] 表示字符串 s 第 i 个字符和字符串 s 第 j 个字符之间的子串是否是回文子串
		// i 最大值为 length - 1
		boolean[][] dp = new boolean[length][length];

		// dp[0][0] 表示字符串 s 第 0 个字符和字符串 s 第 0 个字符之间的的子串是否是回文子串
		// dp[3][3] 表示字符串 s 第 3 个字符和字符串 s 第 3 个字符之间的的子串是否是回文子串
		// dp[i][i] 表示字符串 s 第 i 个字符和字符串 s 第 i 个字符之间的的子串是否是回文子串
		// 此时，这个区间的字符只有一个，肯定是回文子串
		for (int i = 0; i < length; i++) {
			dp[i][i] = true;
		}
		// 设置变量记录最长的回文子串的长度
		int maxLen = 1;
		// 设置变量记录最长的回文子串的开始位置
		int begin = length - 1;
		// i 从字符串 s 的【尾部】开始向前遍历，j 从 i + 1 开始向后遍历
		// 不断的逼近二维数组最右上角的位置，即求 dp[0][length - 1]
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i + 1; j < length; j++) {
				// 如果发现 s.charAt(i) == s.charAt(j)
				if (s.charAt(i) == s.charAt(j)) {
					// 如果 [i , j] 这个区间中只有 2 个字符，并且此时两个字符还是一样的
					// 那么肯定是回文子串
					// 假设 i = 5， j = 6，[i , j] 这个区间中只有 2 个字符
					// 如果不加这个判断的话，dp[i][j] = dp[ i + 1 ][ j - 1 ]
					// 此时，i + 1 = 6， j - 1 = 5
					// [ 6 , 5 ] 这个区间不存在，默认值为 false
					if ((j - i + 1) == 2) {
						dp[i][j] = true;
					} else {
						// 否则，当前这个区间是否是回文子串区间取决于 [ i + 1 , j - 1 ] 这个区间
						dp[i][j] = dp[i + 1][j - 1];
					}
				} else {
					// 如果发现 s.charAt(i) ！= s.charAt(j)
					// 那说明 [i , j] 这个区间必然不是回文子串
					dp[i][j] = false;
				}
				// 更新最长的回文子串长度
				if (dp[i][j] && j - i + 1 > maxLen) {
					// 更新最长的回文子串长度
					maxLen = j - i + 1;
					// 更新最长的回文子串的开始位置
					begin = i;
				}
			}

		}

		// 通过截取的方式返回最长的回文子串
		// Java substring() 方法
		// beginIndex -- 起始索引（包括）, 索引从 0 开始
		// endIndex -- 结束索引（不包括）
		//  0  1  2  3  4
		//  b  a  b  a  d
		// 此时，begin = 1，maxLen = 3
		// substring( 1 , 4 )，即截取 [1 , 4 ) ，左闭右开的区间
		// 获取子串  aba
		return s.substring(begin, begin + maxLen);
	}


	public String longestPalindrome(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			// 以 s[i] 为中心的最长回文子串
			String s1 = palindrome(s, i, i);
			// 以 s[i] 和 s[i+1] 为中心的最长回文子串
			String s2 = palindrome(s, i, i + 1);
			// res = longest(res, s1, s2)
			res = res.length() > s1.length() ? res : s1;
			res = res.length() > s2.length() ? res : s2;
		}
		return res;
	}


	public String palindrome(String s, int l, int r) {
		// 防止索引越界
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			// 双指针，向两边展开
			l--;
			r++;
		}
		// 返回以 s[l] 和 s[r] 为中心的最长回文串
		return s.substring(l + 1, r);
	}

}