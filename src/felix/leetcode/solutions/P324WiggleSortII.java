package felix.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

 * @author luqing.zz
 */
public class P324WiggleSortII {

    public class Solution {

        public void wiggleSort(int[] nums) {
            if (nums == null || nums.length <= 1) return;
            Arrays.sort(nums);
            int mid = (nums.length - 1) / 2;
            int[] tmp = new int[nums.length];
            int p = 0;
            for (int i = mid; i >= 0; --i) {
                tmp[p] = nums[i];
                p += 2;
            }
            p = 1;
            for (int i = nums.length - 1; i > mid; --i) {
                tmp[p] = nums[i];
                p += 2;
            }
            System.arraycopy(tmp, 0, nums, 0, nums.length);
        }
    }
}
