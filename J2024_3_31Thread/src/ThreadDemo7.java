import java.util.Scanner;

public class ThreadDemo7 {
    private static volatile int a = 10;
    private static volatile int b = 10;
    public  static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (a == 10) {

            }
            System.out.println("t1线程结束");
        });
        Object locker = new Object();
        Thread t2 = new Thread(() -> {
            synchronized (locker) {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入");
                 a = sc.nextInt();
                 int c =0;
            }
        });
        t1.start();
        t2.start();
    }
}
