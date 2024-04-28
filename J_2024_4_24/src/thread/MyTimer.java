package thread;

import java.nio.file.LinkOption;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TimerTask;

/**
 * MyTimerTask表示要执行的任务
 */
class MyTimerTask implements Comparable<MyTimerTask> {
    // 在什么时间点来执行这个任务
    // 此处约定这个time是一个ms级别的时间戳
    private long time;
    // 实际任务要执行的代码
    private Runnable runnable;

    public long getTime() {
        return time;
    }

    //delay期望是一个“相对时间”
    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        // 计算一下要执行任务的绝对时间，用绝对时间更方便判断任务是否到时间了
        this.time = System.currentTimeMillis() + delay;
    }
    public void run() {
        runnable.run();
    }

    // 因为要放到优先级队列里，自定义类，必须重写compareTo方法
    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(o.time - this.time);
//        return (int)(this.time - o.time);
    }
}

/**
 * MyTimer表示一个定时器
 */
public class MyTimer {
    // 线程，负责扫描任务队列，看看时间是否到了，时间到了之后就执行任务
    private Thread t = null;
    // 优先级队列，放任务，优先级队列可以确保等待时间短的任务在最前面
    private PriorityQueue<MyTimerTask> priorityQueue= new PriorityQueue<>();
    // 锁对象
    private Object locker = new Object();
    // 将任务添加到队列里
    private void schedule(Runnable runnable, long delay) {
        synchronized (locker) {
            MyTimerTask myTimerTask = new MyTimerTask(runnable, delay);
            priorityQueue.offer(myTimerTask);
            // 唤醒wait的线程
            locker.notify();
        }
    }
    // 构造方法
    // 创建扫描线程，让扫描线程判定和执行
    public MyTimer () {
    // 扫描线程需要循环往复的扫描队首元素（因为队首元素等待的时间最短），
        // 然后判定队首元素的是不是到时间了
        // 如果时间到了就执行，执行完毕后，把这个元素从队列中删除
        // 如果时间没到，就什么也不干
        t = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    // 优化，如果队列里没有元素就先不处理
                    while (priorityQueue.isEmpty()) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    MyTimerTask task = priorityQueue.peek();
                    // 时间到了
                    // 获取当前时间
                    long current = System.currentTimeMillis();
                    if (current >= task.getTime()) {
                        task.run();
                        priorityQueue.poll();
                    } else {
                        // 时间没到就不执行
                        // 优化,不可以用sleep，会错过新添加的元素
                        try {
                            locker.wait(task.getTime() -current);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        MyTimer m = new MyTimer();
        m.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hhh,2000");

            }
        },2000);
        m.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hhh,1000");
            }
        },1000);
    }

}
