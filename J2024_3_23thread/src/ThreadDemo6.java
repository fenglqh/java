import java.util.Comparator;
import java.util.PriorityQueue;
//多线程案例：1.单例模式  2.阻塞队列  3.定时器 4.线程池
/**
 * 定时器类，可以在指定时间
 * 去执行某个任务
 * 1.扫描是否到时间
 * 2.优先级队列来保存要执行的任务
 */
class MyTimer{
//    扫描任务队列执行任务队列的线程
    private  Thread  t = null;
//    锁对象
    private final Object locker = new Object();
//    优先级队列来存放任务
    PriorityQueue<MyTimerTask> priorityQueue = new PriorityQueue<>();
//    任务入队列
    public void schedule(Runnable runnable, long dalay) {
        synchronized (locker) {
            MyTimerTask myTimerTask = new MyTimerTask(runnable, dalay);
            priorityQueue.offer(myTimerTask);
            locker.notify();
        }
    }
//    public void cancel() {
//        t.stop();
//    }
//    构造方法，创建扫描线程
    public MyTimer() {
//        不断判断队首元素是否到时间了
//        如果到时间就执行，然后删除
//        没到时间就继续扫描，什么也不干
        Thread t = new Thread(() -> {
//            synchronized (locker) {放在这也行，但看起来代码有风险
                while (true) {
                    try {
                        synchronized (locker) {
                            while (priorityQueue.isEmpty()) {
//                        continue;
                                locker.wait();
                            }

                            MyTimerTask task = priorityQueue.peek();
                            long currentTime = System.currentTimeMillis();
                            if (task.getTime() >= currentTime) {
                                priorityQueue.poll();
                                task.run();
                            } else {
//                    continue;
//                            避免忙等
                                locker.wait(task.getTime() - currentTime);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        t.start();

    }
}
/**
 描述一个任务,
 这个任务要放到优先级队列中
 */
class MyTimerTask implements Comparable<MyTimerTask> {
//在什么时间来执行这个任务
//    约定time是个ms级别的时间戳，当前时间到1970年月1日的时间差
    private long time;
//    实际任务要执行的代码,也可以实现接口
    private Runnable runnable;
//    delay是相对时间
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
//        计算绝对时间
        this.time = System.currentTimeMillis() + delay;
    }

    public void run() {
        runnable.run();
    }

    public long getTime() {
        return this.time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time - o.time);
    }
}
public class ThreadDemo6 {
    public static void main(String[] args) {
        MyTimer m = new MyTimer();
        m.schedule(() -> {
            System.out.println("hhh1");
        }, 1000L);
        m.schedule(() -> {
            System.out.println("hhh2");
        }, 2000L);
        m.schedule(() -> {
            System.out.println("hhh3");
        }, 3000L);

        System.out.println("main");

    }
}
