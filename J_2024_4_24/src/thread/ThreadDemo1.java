package thread;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadDemo1 implements Runnable {
    public static void main1(String[] args) {
        Thread t = new Thread(()->{
            while (true) {
                System.out.println("jjj");
            }
        });
//        t.setDaemon(true);//后台线程
        t.start();
        System.out.println(t.isDaemon());
    }
    private static Timer timer = new Timer();
    public Timer getTimer() {
        return timer;
    }
    public static void main(String[] args) throws InterruptedException {
//        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,3000");
            }
        },3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,1000");
            }
        }, 1000);
//        timer.schedule(()->{
//            System.out.println("hhh,2000");
//        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,2000");
            }
        }, 2000);
        Thread.sleep(4000);
        System.out.println("main方法结束");
    }

    @Override
    public void run() {

    }
}
