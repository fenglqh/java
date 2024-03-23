public class ThreadDemo7{
//    a线程唤醒b线程的前提是不是b线程已经释放了锁
    private Object locker = new Object();

    public void a () throws InterruptedException {
        synchronized (locker) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            locker.wait();
            System.out.println("hhh");
        }
    }

    public void b() {
        synchronized (locker) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            locker.notify();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("kkk");
//            locker.notify();
        }
    }

    public static void main(String[] args) {
        ThreadDemo7 t = new ThreadDemo7();
        Thread thread = new Thread(() -> {
            try {
                t.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );
        thread.start();
        Thread thread1 = new Thread(() -> {
            t.b();
        });
        thread1.start();

    }
}
