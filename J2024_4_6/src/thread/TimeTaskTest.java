package thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 练习TaskTest类的使用
 * 和练习Timer类
 * Timer类是一个带有阻塞功能的优先级队列（小根堆）,内置了一个线程
 * TaskTest类，是抽象类，用来表示等待的任务到底要做什么
 */
public class TimeTaskTest {
    public static void main(String[] args) throws InterruptedException {
        // 首先要一个Timer类，为了存放要按顺序执行的工作
        Timer timer = new Timer();
        // 往里面放入任务，并设定时间，这里是一个相对时间以秒为单位，
        // 放入队列的时候开始计时
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello2000");
            }
        }, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello1000");
            }
        }, 1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello3000");
            }
        }, 3000);
        System.out.println("main");
        Thread.sleep(4000);//确保所有的任务都能执行完
        timer.cancel();
    }


}
