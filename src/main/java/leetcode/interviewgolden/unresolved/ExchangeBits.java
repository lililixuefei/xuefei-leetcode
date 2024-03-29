package leetcode.interviewgolden.unresolved;

/**
 * @description: 配对交换
 * @author: xuefei
 * @date: 2023/09/20 19:48
 */
public class ExchangeBits {

    public int exchangeBits(int num) {
        // 奇数
        int odd = num & 0x55555555;
        // 偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }

}
