package leetcode.top100.dp.knapsack;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 7:11 PM
 * @Version 1.0
 */
public class CoinChangeII {


	public static void main(String[] args) {
//		List<Integer> coins = new ArrayList<>();
//		coins.add(1);
//		coins.add(2);
//		coins.add(5);
        int[] coins = new int[]{1,2,5};
//        System.out.println(coinChange1(coins, 11));
        System.out.println(coinChange(11, coins));
	}

	public static int coinChange(int amount, int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];
		// base case
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j - coins[i - 1] >= 0) {
					// dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; 和 dp[i][j] = dp[i - 1][j] + dp[i-1][j - coins[i - 1]]; 的含义是不同的。
					// dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; 的含义是，使用前 i 种硬币组成金额 j 的组合数等于使用前 i-1 种硬币组成金额 j 的组合数
					//（即不使用第 i 种硬币）和使用前 i 种硬币组成金额 j-coins[i-1] 的组合数（即使用第 i 种硬币）之和。
					// 而 dp[i][j] = dp[i - 1][j] + dp[i-1][j - coins[i - 1]]; 的含义是，使用前 i 种硬币组成金额 j 的组合数等于使用前 i-1 种硬币组成金额
					// j 的组合数和使用前 i-1 种硬币组成金额 j-coins[i-1] 的组合数之和，这实际上忽略了使用第 i 种硬币的可能性，因此是错误的。
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount];
	}


    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }

}
