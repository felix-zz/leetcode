/*
 * Copyright 1999-2101 Alibaba.com. All rights reserved.
 * This software is the confidential and proprietary information of Alibaba.com ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms of
 * the license agreement you entered into with Alibaba.com.
 */
package felix.leetcode.solutions;

/**
 * https://leetcode.com/problems/bulb-switcher/

There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

 * @author luqing.zz
 */
public class P319BulbSwitcher {

    public class Solution {

        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
}
