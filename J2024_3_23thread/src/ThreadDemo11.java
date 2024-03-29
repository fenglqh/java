public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程正在执行~~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程执行结束~~");
        });
        t.start();

        t.interrupt();
        System.out.println("线程被中断~~");
    }
}
