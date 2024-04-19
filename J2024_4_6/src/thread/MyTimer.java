package thread;

import java.util.PriorityQueue;

/**
 * 简单模拟实现一下定时器功能
 * 第一遍不大懂，先抄一遍理解
 */

// 任务类
class MyTimerTask {
    private Runnable runnable = null;

}
// 带有优先级的阻塞队列，表示一个定时器
public class MyTimer {
    // 负责扫描任务的队列，执行任务的线程
    private Thread t = null;
    // 任务队列,原码中其实是用普通的队列，先实现堆，后再阻塞
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    // 往队列里放入任务
    public void schedule(Runnable runnable, long delay) {
        queue.add(new MyTimerTask());
    }
    // 结束t线程
    public void cancel() {

    }
    // 构造方法
    public MyTimer() {

    }
}
