package oj;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution3 {

    public static void main3(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        // 高精度求和 本质是模拟
        Integer aa = Integer.valueOf(a);
        Integer bb = Integer.valueOf(b);
        Stack<Integer> st = new Stack<>();
        int tmp = 0;
        while (aa != 0 || bb != 0) {
            tmp += (aa % 2 + bb % 2);
            st.push(tmp % 2);
            tmp = tmp / 2;
            if (aa == 1) aa = 0;
            else aa = aa / 10;
            if (bb == 1) bb = 0;
            else bb = bb / 10;
        }
        if (tmp != 0) st.push(tmp);

        String ret = "";
        while (!st.isEmpty()) ret += st.pop();

        return ret;

    }
    public static void main(String[] args) {
        String a = "33";
        int c = a.charAt(0) - '0';
        int d = a.charAt(1) - '0';

        System.out.println(c);
        System.out.println(d);
        int s = c + d;
        System.out.println(s);
//        Integer i = Integer.valueOf(a);
//        List<Integer> list = Arrays.asList(i);
//        System.out.println(list);
//        Stack stack = new Stack();
//        stack.push(i);
//        stack.pop();

    }
    public static void main2(String[] args) {
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
