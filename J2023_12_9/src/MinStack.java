import java.util.Stack;
/**
 * 不用辅助栈也可以写
 */

/**
 * 最小栈
 */
class MinStack2{
    Stack<Integer> stack = new Stack<>();

    private int min = 0;
    public void push(int val) {
        if (stack.empty()) {
            stack.push(val);
            min = val;
        } else {
           stack.push(val);
           if (val <= min) {
               min = val;
           }
           stack.push(min);
        }
    }

    public void pop() {
        if (!stack.empty()) {
            stack.pop();
            stack.pop();
        }
    }

    public int top() {
        int peek = 0;
        if (!stack.empty()) {
            int ret = stack.pop();
            peek = stack.peek();
            stack.push(ret);
            return peek;
        }
        return stack.peek();

    }

    //    public int getMin() {
//        if (stack.empty()) {
//            return -1;
//        }
//        int ret = stack.peek();
//        while (!stack.empty()) {
//            int temp = stack.peek();
//            if (temp < ret) ret = temp;
//            stack.pop();
//        }
//        return ret;
//    }
//    对于之前的思路一个栈完成不了，因为找到最小值之后栈就空了
    public int getMin() {
        return stack.peek();
    }
}
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        if (stack.empty()) {
            stack.push(val);
            minstack.push(val);
        } else {
            stack.push(val);
            if (minstack.peek() >= val) {
                minstack.push(val);
            }
        }
    }

    public void pop() {
        if(!stack.empty()) {
            int ret = stack.pop();
            if (ret == minstack.peek()) {
                minstack.pop();
            }

        }
    }

    public int top() {
        if(!stack.empty()) {
            return stack.peek();
        }
        return -1;

    }

//    public int getMin() {
//        if (stack.empty()) {
//            return -1;
//        }
//        int ret = stack.peek();
//        while (!stack.empty()) {
//            int temp = stack.peek();
//            if (temp < ret) ret = temp;
//            stack.pop();
//        }
//        return ret;
//    }
//    对于之前的思路一个栈完成不了，因为找到最小值之后栈就空了
    public int getMin() {
        return minstack.peek();
    }

}
