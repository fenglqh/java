public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hh");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhh2");
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
    public static void main2(String[] args) {
        Thread t1 = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hh");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhh2");
            }
        });
        t1.start();
        t2.start();
    }
    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //cpu执行速度太快了，通过让线程sleep的方式让输出速度慢一点
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhh~t1");
            }
            System.out.println("t1线程执行结束");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhhh333");
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hhh~t2");
            }
            System.out.println("t2线程执行结束");

        });
        t1.start();
        t2.start();
        System.out.println("main线程执行结束");
    }
}
