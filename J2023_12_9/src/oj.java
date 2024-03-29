import java.util.Stack;

public class oj {
    //判断字符串中括号是否有效闭合
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{'|| s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty()) {
                    int ret = stack.peek();
                    char get = s.charAt(i);
                    if ((ret == '(' && get == ')') || (ret == '{' && get == '}')
                            || (ret == '[' && get == ']') ) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

//    逆波兰表达式
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length ; i++) {
            // if((tokens[i] == "+") || (tokens[i] == "-") || tokens[i] == "*" || tokens[i] == "/" ) {

            // }
            switch(tokens[i]) {
                case "+" :{
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left + right);
                    break;
                }
                case "-":{
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left - right);
                    break;
                }
                case "*":{
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left * right);
                    break;
                }
                case "/": {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left / right);
                    break;
                }
                default:{
                    int ret = Integer.valueOf(tokens[i]);
                    stack.push(ret);
                    break;
                }
            }
        }
        return stack.peek();
    }


//栈的弹出压入
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        // write code here
        if (pushV == null) {
            return false;
        }
        if (popV == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 0; i < pushV.length ; i++) {
            stack.push(pushV[i]);
            while (j < popV.length && !stack.empty() &&  stack.peek().equals(popV[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        int[] pushV = {2,1,0};
        int[] popV = {1,2,0};
        boolean ret = IsPopOrder(pushV,popV);
        System.out.println(ret);
    }
}
