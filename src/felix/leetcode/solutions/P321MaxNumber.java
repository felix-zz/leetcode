package felix.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-maximum-number/
 * 

Given two arrays of length m and n with digits 0-9 representing two numbers. 
Create the maximum number of length k <= m + n from digits of the two. 
The relative order of the digits from the same array must be preserved. 
Return an array of the k digits. 
You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]

 * @author luqing.zz
 */
public class P321MaxNumber {

    public class Solution {

        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[][] seqs1 = getSeqs(nums1);
            int[][] seqs2 = getSeqs(nums2);
            int[] max = new int[k];
            int[] tmp = new int[k];
            Arrays.fill(max, -1);
            int c1 = k - nums2.length;
            if (c1 < 0) c1 = 0;
            for (; c1 <= nums1.length; ++c1) {
                int c2 = k - c1;
                if (c2 < 0) break;
                int[] sub1 = seqs1[c1];
                int[] sub2 = seqs2[c2];
                merge(sub1, sub2, tmp);
                if (compare(max, tmp) < 0) {
                    System.arraycopy(tmp, 0, max, 0, k);
                }
            }
            return max;
        }

        private void merge(int[] sub1, int[] sub2, int[] targ) {
            int i1 = 0, i2 = 0, it = 0;
            for (; i1 < sub1.length && i2 < sub2.length;) {
                if (sub1[i1] > sub2[i2]) {
                    targ[it++] = sub1[i1++];
                } else if (sub1[i1] < sub2[i2]) {
                    targ[it++] = sub2[i2++];
                } else {
                    int tmp = sub1[i1];
                    int ii1 = i1, ii2 = i2;
                    while (ii1 < sub1.length && ii2 < sub2.length && sub1[ii1] == tmp && sub2[ii2] == tmp) {
                        targ[it++] = sub1[ii1];
                        ++ii1;
                        ++ii2;
                    }
                    if (compare(sub1, sub2, ii1, ii2) < 0) {
                        i2 = ii2;
                    } else {
                        i1 = ii1;
                    }
                }
            }
            for (; i1 < sub1.length; ++i1) {
                targ[it++] = sub1[i1];
            }
            for (; i2 < sub2.length; ++i2) {
                targ[it++] = sub2[i2];
            }
        }

        private int[][] getSeqs(int[] nums) {
            int[][] seq = new int[nums.length + 1][];
            int[][] hash = new int[10][nums.length];
            int[] hashlen = new int[10];
            for (int i = 0; i < 10; ++i) {
                Arrays.fill(hash[i], -1);
            }
            for (int i = 0; i < nums.length; ++i) {
                int n = nums[i];
                hash[n][hashlen[n]++] = i;
            }
            for (int k = 0; k <= nums.length; ++k) {
                seq[k] = new int[k];
                getMaxKNum(nums, hash, k, seq[k]);
            }
            return seq;
        }

        private void getMaxKNum(int[] nums, int[][] hash, int k, int[] seq) {
            int ik = 0;
            int in = -1;
            for (int n = 9; n >= 0; --n) {
                int remaink = k - ik;
                if (remaink == 0) break;
                for (int hp = 0; hash[n][hp] >= 0; ++hp) {
                    int idx = hash[n][hp];
                    if (nums.length - idx < remaink) {
                        break;
                    }
                    if (idx > in) {
                        in = idx;
                        seq[ik++] = nums[in];
                        n = 10;
                        break;
                    }
                }
            }
        }

        private int compare(int[] r1, int[] r2) {
            return compare(r1, r2, 0, 0);
        }

        private int compare(int[] r1, int[] r2, int from1, int from2) {
            int len1 = r1.length - from1;
            int len2 = r2.length - from2;
            int minlen = Math.min(len1, len2);
            for (int i = 0; i < minlen; ++i) {
                int delta = r1[i + from1] - r2[i + from2];
                if (delta > 0) {
                    return 1;
                } else if (delta < 0) {
                    return -1;
                }
            }
            return len1 - len2;
        }

    }

}
