package thread;


/**
 * 模拟实现阻塞队列
 */
public class BlookingQueue {
    // 底层用一个数组来实现
    private int[] elems = new int[5];
    // 记住队首位置
    private int rear;
    // 记住队尾位置
    private int tail;
    // 记住已经使用的元素个数
    private int usedSize;
    // 锁对象
    private Object locker = new Object();

    public BlookingQueue() {}

    public BlookingQueue(int initial) {
        this.elems = new int[initial];
    }

    public void offer(int data) throws InterruptedException {
        // 如果队列满，则阻塞
        synchronized (locker) {
            while (this.usedSize == this.elems.length) {
                locker.wait();
            }
            this.elems[this.tail++] = data;
            // 处理边界情况
            if (this.tail == this.elems.length) this.tail = 0;
            this.usedSize++;
            locker.notify();
        }
    }
    public int poll() throws InterruptedException {
        synchronized (locker) {
            // 如果队列空，则阻塞
            while (this.usedSize == 0) locker.wait();
            int ret = elems[this.rear++];
            if (this.rear == this.elems.length) this.rear = 0;
            this.usedSize--;
            locker.notify();
            return ret;
        }
    }

}
