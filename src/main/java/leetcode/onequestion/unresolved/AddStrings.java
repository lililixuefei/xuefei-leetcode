package leetcode.onequestion.unresolved;

/**
 * @description: 字符串相加
 * @author: xuefei
 * @date: 2023/07/17 22:55
 */
public class AddStrings {

	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		String res = "";
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				carry += num1.charAt(i--) - '0';
			}
			if (j >= 0) {
				carry += num2.charAt(j--) - '0';
			}
			res = (carry % 10) + res;
			carry /= 10;
		}
		return carry != 0 ? "1" + res : res;
	}

}
