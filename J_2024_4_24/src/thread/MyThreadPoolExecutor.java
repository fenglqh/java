package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPoolExecutor {

    private List<Thread> threads = new ArrayList<>();
    // 任务队列 存放要执行的任务
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
    // 一个构造方法指定创建多少个线程 并在构造方法中创建好这些线程
    public MyThreadPoolExecutor(int corePoolSize) {
        for (int i = 0; i < corePoolSize; i++) {
            Thread thread = new Thread(() -> {
                // 从任务队列中取任务执行
                while (true) {
                    try {
                        // 此处的take是带有阻塞功能的
                        // 如果队列为空，这里的take操作就会进入阻塞状态
                        Runnable take = queue.take();
                        // 执行任务
                        take.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    // 向队列中添加新的任务
    public void submit(Runnable task) throws InterruptedException {
        // 这里的put也带有阻塞功能，当队列满了，这里的put操作就会进入阻塞状态
        queue.put(task);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPoolExecutor m = new MyThreadPoolExecutor(5);
        for (int i = 0; i < 100; i++) {
            // i 是变量，变量捕获不能直接访问
            int n = i; // 事实常量
            m.submit(() -> {
                System.out.println("执行任务" + n + " ,当前线程为：" + Thread.currentThread().getName());
            });
        }
    }
}

