package felix.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * 

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

 * @author luqing.zz
 */
public class P318MaxProduct {

    public class Solution {

        public int maxProduct(String[] words) {
            int[][] hash = new int[26][words.length];
            int[] hashLen = new int[26];
            initHash(hash, hashLen, words);
            int max = 0;
            boolean[] remainder = new boolean[words.length];
            for (int w = 0; w < words.length; ++w) { //String w: words) {
                String word = words[w];
                Arrays.fill(remainder, true);
                remainder[w] = false;
                for (int i = 0; i < word.length(); ++i) {
                    int c = word.charAt(i) - 'a';
                    for (int j = 0; j < hashLen[c]; ++j) {
                        remainder[hash[c][j]] = false;
                    }
                }
                for (int i = 0; i < remainder.length; ++i) {
                    if (false == remainder[i]) continue;
                    int m = word.length() * words[i].length();
                    if (m > max) max = m;
                }
            }
            return max;
        }

        private void initHash(int[][] hash, int[] hashLen, String[] words) {
            Arrays.fill(hashLen, 0);
            for (int i = 0; i < hash.length; ++i) {
                Arrays.fill(hash[i], -1);
            }
            boolean[] flags = new boolean[26];
            Arrays.fill(flags, false);
            for (int w = 0; w < words.length; ++w) {
                String word = words[w];
                for (int i = 0; i < word.length(); ++i) {
                    int c = word.charAt(i) - 'a';
                    if (flags[c]) continue;
                    hash[c][hashLen[c]] = w;
                    ++hashLen[c];
                    flags[c] = true;
                }
            }
        }
    }
}
