package felix.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

 * @author luqing.zz
 */
public class P322CoinChange {

    public class Solution {

        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0) return -1;
            java.util.Arrays.sort(coins);
            int cnt[] = new int[amount + 1];
            Arrays.fill(cnt, -1);
            cnt[0] = 0;
            for (int c = 1; c < cnt.length; ++c) {
                int min = -1;
                for (int i = 0; i < coins.length; ++i) {
                    if (coins[i] <= c && cnt[c - coins[i]] >= 0) {
                        int prev = cnt[c - coins[i]];
                        if (min == -1 || min > prev + 1) {
                            min = prev + 1;
                        }
                    }
                }
                cnt[c] = min;
            }
            return cnt[amount];
        }
    }
}
