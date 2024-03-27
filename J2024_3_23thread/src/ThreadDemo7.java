
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 固定线程池
 * 1.提供构造方法，指定创建多少个线程
 * 2.在构造方法中，把这些线程都创建好
 * 3.有一个阻塞队列，能够持有要执行的任务
 * 4.提供submit方法，可以添加新的任务
 */
class MyFixedThreadPoolExecutor {
//    阻塞队列用来存放要执行的任务
    private BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1000);
    private List<Thread> list = new ArrayList<>();
//    指定创建多少个线程
    public MyFixedThreadPoolExecutor(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = null;
                t = new Thread(() -> {
                    while (true) {
                        try {
                            // 取出任务
                            Runnable runnable = blockingQueue.take();
                            //执行任务
                            runnable.run();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
                list.add(t);
            }
    }
//    添加新的任务
    public void submit(Runnable runnable) throws InterruptedException {
        //线程安全的
        blockingQueue.put(runnable);
    }
}
public class ThreadDemo7 {

    public static void main(String[] args) throws InterruptedException {
        MyFixedThreadPoolExecutor m = new MyFixedThreadPoolExecutor(5);

        for (int i = 0; i < 1000; i++) {
            int j = i;
            m.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("这是第" + j + "个任务"+Thread.currentThread().getName());
                }
            });
        }
        Thread.sleep(5000);
        System.out.println("hhhh1");
    }
}
