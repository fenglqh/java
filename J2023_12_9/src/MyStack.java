import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /*
    用队列实现栈
     */
    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        if(queue2.isEmpty()) {
            queue1.offer(x);
        } else {
            int size = queue2.size();
            while(size > 0) {
                int ret = queue2.poll();
                queue1.offer(ret);
                size--;
            }
            queue1.offer(x);
        }
    }

    public int pop() {
        if (!queue2.isEmpty()) {
            return queue2.poll();
        } else {
            int size = queue1.size();
            while (size - 1 > 0) {
                if (queue1.isEmpty()) {
                    return -1;
                }
                int ret = queue1.poll();
                queue2.offer(ret);
                size--;
            }
            Queue<Integer> temp = null;
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        return queue2.poll();
    }

    public int top() {
        if (!queue2.isEmpty()) {
            return queue2.poll();
        }
        int size = queue1.size();
        while (size - 1 > 0) {
            if (queue1.isEmpty()) {
                return -1;
            }
            int ret = queue1.poll();
            queue2.offer(ret);
            size--;
        }
        Queue<Integer> temp = null;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return queue2.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
