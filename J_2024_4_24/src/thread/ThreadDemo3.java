package thread;

import java.util.PriorityQueue;

/**
 * 模拟任务类
 */
abstract class MockTimeTask implements Comparable<MockTimeTask>{
    // time 是ms级别的时间戳
    public long time;
    public void run() {

    }
    @Override
    public int compareTo(MockTimeTask o) {
        return (int)(o.time - this.time);
//        return (int)(this.time - o.time);不确定顺序就试一试
    }
}

/**
 * 模拟定时器
 */
class MockTimer {
    // 任务队列
    private volatile PriorityQueue<MockTimeTask> queue = null;
    // 扫描线程
    private Thread thread = null;
    // 锁对象
    private Object locker = new Object();
    public MockTimer () {
        this.queue = new PriorityQueue<>();
        // 线程开始扫描任务队列的头，到时间就执行run方法,执行完就删除元素，没到时间就啥也不干
        this.thread = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    // 如果任务对列为空则什么也不干
                    if (queue.isEmpty()) {
                        continue;
                    }
                    MockTimeTask task = queue.peek();
                    // 当前时间
                    long currentTime = System.currentTimeMillis();
                    if (currentTime >= task.time) {
                        // 时间到了就执行任务
                        task.run();
                        queue.poll();
                    } else {

                    }
                }
            }});
        thread.start();

    }

    // 向任务队列中添加任务, delay是相对时间
    public void schedule(MockTimeTask task, long delay) {
        //time是ms级别的时间戳，这样更方便比较是不是到时间了
        synchronized (locker) {
            task.time = System.currentTimeMillis() + delay;
            queue.add(task);
        }
    }
}
public class ThreadDemo3 {
    public static void main(String[] args) {
        MockTimer mockTimer = new MockTimer();
        mockTimer.schedule(new MockTimeTask() {
            @Override
            public void run() {
                super.run();
                System.out.println("hhh1000");
            }
        }, 1000);
        mockTimer.schedule(new MockTimeTask() {
            @Override
            public void run() {
                super.run();
                System.out.println("hhh2000");
            }
        }, 2000);

    }

}