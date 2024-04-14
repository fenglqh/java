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
    // 锁对象，也可以使用this
    private Object locker = new Object();

    public BlookingQueue() {}

    public BlookingQueue(int initial) {
        this.elems = new int[initial];
    }

    public void put(int data) throws InterruptedException {
        // 如果队列满，则阻塞，
        // 锁加到这里和加到方法上本质是一样的，加到方法上是给this加锁，此处是给locker加锁
        synchronized (locker) {
            // 队列满了，就需要让代码进行阻塞
            while (this.usedSize == this.elems.length) {
                // 使用while
                // 因为如果其他阻塞中的put被take唤醒，顺利执行后有可能会唤醒另一个线程的put
                // 用if的话往下执行的时候，其实队列已经满了，这样就会会bug，所以用while来再进行一次判断
                locker.wait();
            }
            // 进入队列的元素放到tail指向的位置
            this.elems[this.tail++] = data;
            // 处理边界情况，用的是循环数组，超出数组下标了，需要置零
            if (this.tail == this.elems.length) this.tail = 0;
            this.usedSize++;
            // 入队列成功之后，进行唤醒操作
            locker.notify();
        }
    }
    public int take() throws InterruptedException {
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
