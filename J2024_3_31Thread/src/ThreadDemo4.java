public class ThreadDemo4 {
    //典型的线程不安全问题
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int count1 = 0;
            for (int i = 0; i < 5000; i++) {
                count1++;
            }
            count = count + count1;
        });
        Thread t2 = new Thread(() -> {
            int count2 = 0;
            for (int i = 0; i < 5000; i++) {
                count2++;
            }
            count = count + count2;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }
}
