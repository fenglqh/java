package oj;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution3 {

    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c'};
        String s = new String(c, 0, 0);// 左闭右开
        System.out.println(s);
    }
    public static void main6(String[] args) {
        String a = "y#fo##f";
        String b = "y#f#o##f";
        System.out.println(backspaceCompare(a, b));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack st1 = new Stack(), st2 = new Stack();
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '#' && !st1.isEmpty()) st1.pop();
            if (s.charAt(i) != '#') st1.push(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == '#' && !st2.isEmpty()) st2.pop();
            if (t.charAt(i) != '#') st2.push(t.charAt(i));
        }
        if (st1.size() != st2.size()) return false;
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.pop() != st2.pop()) return false;
        }
        return true;
    }
    public static void main5(String[] args) {
        String a = "123";
        String b = "0";
        Stack stack = new Stack();

        System.out.println(multiply(a, b));
    }
    public static String multiply(String num1, String num2) {
        // 在暴力模拟上的优化： 无进位相乘然后相加，最后处理进位
        int m = num1.length(), n = num2.length();
        int[] tmp = new int[m + n - 1];
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                tmp[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        StringBuffer sb = new StringBuffer();
        int t = 0;
        for (int k = tmp.length - 1; k >= 0; k--) {
            t += tmp[k];
            sb.append(t % 10);
            t = t / 10;
        }
        if (t != 0) sb.append(t);
        sb.reverse();

        // 处理0多情况
        int i = 0;
        while (sb.charAt(i) == '0' && i < tmp.length - 1) i++;

        return sb.substring(i);
    }
    public static void main4(String[] args) {
        String a = "13";
        StringBuffer sb = new StringBuffer(a);
        String substring = sb.substring(0);
        System.out.println(substring);
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
    public static void main3(String[] args) {
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
