import java.util.Scanner;

public class ThreadDemo6 {
    private static int flag;
    public static void main(String[] args) {
//        高度依赖编译器优化
        Thread t1 = new Thread(() -> {
            while (flag == 0) {
//                try {
//
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("结束");
        });
        Thread t2 = new Thread(() -> {
            Scanner s = new Scanner(System.in);
            flag = s.nextInt();


        });
        t1.start();
        t2.start();
    }
}
