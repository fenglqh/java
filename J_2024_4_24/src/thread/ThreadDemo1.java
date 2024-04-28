package thread;

import java.util.*;

public class ThreadDemo1{
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhhh,5000");
            }
        },5000);
        Thread t = new Thread(() -> {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("hhhh,4000");
                    timer.cancel();
                }
            },4000);
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("jjjj");
            }
        });
        t.start();
    }
    public static void main2(String[] args) {
      Timer timer = new Timer();
        long l0 = System.currentTimeMillis();
//        timer.schedule(new TimerTask() {
//          @Override
//          public void run() {
//              System.out.println("hhhh,2000");
//          }
//      },5000,1);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhhh,2000");
                timer.cancel();
            }
        },5000,1);


    }
    public static void main1(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,3000");
            }
        },3000);
//        timer.schedule(new );
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,1000");
            }
        }, 1000);
//        timer.schedule(() -> {System.out.println("hhh,2000");},2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hhh,2000");
            }
        }, 2000);
        Thread.sleep(4000);
        System.out.println("main方法结束");
    }


}
