package thread;

public class ThreadDemo1 {
    private static final Object locker1 = new Object();
    private static final Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker1) {
                System.out.println("wait");
//                try {
//                    locker1.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("hhh");
            }
        });
        Thread t2 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (locker1) {
                System.out.println("ttt");
                locker1.notify();
            }
        });
        t1.start();
        t2.start();
    }
    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {

            System.out.println("hhh");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ttt");
            locker1.notify();
        });
        t1.start();
        t2.start();
    }
}
