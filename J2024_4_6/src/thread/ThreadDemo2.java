package thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                System.out.println("t1进入等待");
                try {
                    locker1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1执行完毕");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);//为了确保t1的wait先于notify执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker1) {
                System.out.println("线程唤醒");
                locker1.notify();
                System.out.println("t2执行完毕");
            }
        });
        t1.start();
        t2.start();
    }
}
