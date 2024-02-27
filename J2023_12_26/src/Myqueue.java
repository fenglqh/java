/**
 * 用栈实现列表
 */
import java.util.Stack;

class Myqueue {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;
    public Myqueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int size = stack1.size();
        if(stack1.empty() && stack2.empty()) {
            return -1;

        }
        if(!stack2.empty()) {
            return stack2.pop();
        } else{
            while(size > 0) {

                int ret = stack1.pop();
                stack2.push(ret);
                size--;
            }
        }
        return stack2.pop();
    }

    public int peek() {
        int size = stack1.size();
        if(stack1.empty() && stack2.empty()) {
            return -1;

        }
        if(!stack2.empty()) {
            return stack2.peek();
        } else{
            while(size > 0) {

                int ret = stack1.pop();
                stack2.push(ret);
                size--;
            }
        }
        return stack2.peek();

    }

    public boolean empty() {

        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */