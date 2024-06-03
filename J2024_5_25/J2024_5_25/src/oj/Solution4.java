package oj;

import java.util.Stack;

public class Solution4 {
    public static void main(String[] args) {
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
