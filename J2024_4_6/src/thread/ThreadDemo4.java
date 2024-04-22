package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadDemo4 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);
        Thread t1 = new Thread(() -> {
            int n = 1;
            while (true) {
                try {
                    queue.put(n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产元素：" + n);
                n++;
            }
        });
        Thread t2 = new Thread(() -> {
            Integer take = null;
            while (true) {
                try {
                    Thread.sleep(2000);
                    take = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费元素：" + take);
            }
        });
        t1.start();
        t2.start();
    }
}
