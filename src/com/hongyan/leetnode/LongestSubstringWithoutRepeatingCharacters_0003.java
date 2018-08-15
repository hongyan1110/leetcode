package com.hongyan.leetnode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters_0003 {

    public static void main(String[] args) {
        int a = Solution.lengthOfLongestSubstring("dvdf");
        System.out.print(a);
    }

    static class Solution {
        /**
         * 987 / 987 个通过测试用例
         * 执行用时：233 ms
         * @param s
         * @return
         */
        public static int lengthOfLongestSubstring(String s) {

            int max = 0;


            if (s.trim().isEmpty() && s.length() == 1) {
                max = 1;

            } else {
                HashSet charSet = new HashSet();

                char[] chars = s.toCharArray();

                for (char c : chars) {
                    charSet.add(c);
                }

                HashSet tempSet = (HashSet) charSet.clone();

                int t = 0;
                int k = 0;

                for (int i = 0; i < chars.length; i++) {
                    if (tempSet.contains(chars[i])) {
                        tempSet.remove(chars[i]);
                        t++;
                    } else {
                        if (t > max) {
                            max = t;
                        }
                        t = 0;
                        tempSet = (HashSet) charSet.clone();
                        k++;
                        i = k-1;
                    }
                }
                if (t > max) {
                    max = t;
                }
            }


            return max;
        }
    }
}
