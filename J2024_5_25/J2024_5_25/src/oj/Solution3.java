package oj;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        Arrays.sort(str);
        System.out.println(longestCommonPrefix(str));
    }
    public static String longestCommonPrefix(String[] strs) {
        // 解法 两两比较
        String prev = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            String tmp = "";
            for (int j = 0; j < prev.length() && j < cur.length(); j++) {

                if (prev.charAt(j) == cur.charAt(j)) tmp += prev.charAt(j);
                else break;
            }
            prev = tmp;
        }
        return prev;
    }
}
