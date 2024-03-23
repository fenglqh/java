public class MyBlockedQueue {
//    用数组来模拟阻塞队列
    private String[] elems = null;
//    队列元素的大小
    private int size = 0;
//    队列的头
    private int head = 0;
//    队列的尾
    private int tail = 0;
    private Object locker = new Object();
    public void put(String elem) throws InterruptedException {
//        判断是不是满
        synchronized (locker) {
            if (size >= elem.length()) {
//                return;
                locker.wait();
            }
            elems[tail] = elem;
            tail++;
            if (tail >= elems.length) {
                tail = 0;
            }
            size++;
        }
    }

    public String take() throws InterruptedException {
//        判断是不是空
        synchronized (locker) {
            if (size == 0) {
//                return null;
                locker.wait();
            }
            String elem = elems[head];
            head++;
            if (head >= elems.length) {
                head = 0;
            }
            size--;
            return elem;
        }
    }
}
