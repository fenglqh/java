package oj;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        String a = "babad";
//        String ret = a.substring(0,2);// 左闭右开
//        System.out.println(ret);
        System.out.println(longestPalindrome(a));
    }
    public static String longestPalindrome(String s) {
//      1. 中心扩展算法
        int len = 0;
        String ret = null;
        for (int i = 0; i < s.length(); i++) {
            int right = i, left = i;
            while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
                right++;
                left--;
            }
            if ((right - left - 1) > len) {
                ret = s.substring(++left,right);
                len = right - left - 1;
            }
            left = i;
            right = i+1;


        }
        return ret;
    }
    public static void main1(String[] args) {
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
