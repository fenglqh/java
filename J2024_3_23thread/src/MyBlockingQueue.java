//阻塞队列模拟
// 1.一个普通的队列，入队列，出队列,先进先出
// 2. 队列的操作的是线程安全的->  加锁，为了保护队列
// 3. 队列满的时候就等待，队列空的时候也等待
public class MyBlockingQueue {
//    队列的底层使用数组（也可以使用链表，但是链表占得空间比较大）
    private int[] elems = null;
//  记录队列头
    private int head = 0;
//    记录队列尾
    private int tail = 0;
//    记录数组使用了多少
    private int size = 0;
//    锁对象，为了保护队列安全
    private Object locker = new Object();
//    构造方法，给数组进行初始化
    public MyBlockingQueue() {
        elems = new int[5];
    }

//    入队列
    public void offer(int var) {
//        判断数组是否满
        synchronized (locker) {
            while (size >= elems.length) {
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        如果数组不满，就添加
            elems[tail++] = var;
            if (tail >= elems.length) {
                tail = 0;
            }
            size++;
            locker.notify();
        }

    }

//    出队列
    public int poll() {
//        判断数组是否为空
        synchronized (locker) {
            while (size == 0) {
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        如果非空，则出队列
            int ret = elems[head++];
            if (head >= elems.length) {
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }

    }


}
