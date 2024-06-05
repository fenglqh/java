package oj;

import java.util.Stack;

public class Solution4 {
    public static void main(String[] args) {
        String a = "3[a]2[bc]";
        System.out.println(decodeString(a));
    }
    public static String decodeString(String s) {
        // 存储字符串
        String[] tmp1 = new String[s.length()];
        tmp1[0] = "";
        // 存储数字
        int[] tmp2 = new int[s.length()];
        // 标记数组的栈顶位置
        int flag1 = 0, flag2= -1;
        int i = 0;
        // 遍历字符串，分情况讨论
        while (i < s.length()) {
            // 遇到数字
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                String t = "";
                while ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    t += s.charAt(i++);
                }
                tmp2[++flag2] = Integer.valueOf(t);
            } else if (s.charAt(i) == '[') {
                String t = "";
                i++;
                while ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                    t += s.charAt(i++);
                }
                tmp1[++flag1] = t;
            } else if (s.charAt(i) == ']') {
                String r = tmp1[flag1--];
                int r2 = tmp2[flag2--];
                String t = "";
                while (r2 > 0) {
                    t += r;
                    r2--;
                }
                tmp1[flag1] += t;
                i++;
            } else {
                tmp1[flag1] += s.charAt(i++);
            }
        }
        return tmp1[flag1];
    }
    public static void main1(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
    }
    public static int calculate(String s) {
        int tmp = 0;
        char op = '+';
        // 存放数
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                tmp = tmp * 10 + (s.charAt(i)-'0');
            } else {
                if (s.charAt(i) == ' ') continue;
                op = s.charAt(i);
                continue;
            }
            if (op == '+') st.push(tmp);
            else if (op == '-') st.push(-tmp);
            else if (op == '*') {
                tmp *= st.pop();
                st.push(tmp);
            }
            else if (op == '/') {
                tmp = st.pop() / tmp;
                st.push(tmp);
            }
        }
        int ret = 0;
        while (!st.isEmpty()) ret += st.pop();
        return ret;
    }
}
