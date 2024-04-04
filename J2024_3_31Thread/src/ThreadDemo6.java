public class ThreadDemo6 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                //sleep 确保t1能拿到locker锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //持有locker1锁，尝试获取locker2锁
                synchronized (locker2) {
                    System.out.println("1111");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker2) {
                //sleep 确保t1能拿到locker锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //持有locker2锁，尝试获取locker1锁
                synchronized (locker1) {
                    System.out.println("1111");
                }
            }
        });
        t1.start();
        t2.start();
    }
    public static void main1(String[] args) {
        Object locker = new Object();
        Thread t = new Thread(() -> {
            synchronized (locker) {
                synchronized (locker) {
                    System.out.println("hhh");
                }
            }
        });
        t.start();
    }
}
