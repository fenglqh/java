import java.util.Arrays;
import java.util.Random;

/**
 * 实现多线程数组求和
 */
public class MultiThreadArraySum {
    private  int[] arr = new int[100];
//    private  long c = 0;
    public void init() {
        Random random = new Random();
        //            arr[i] = random.nextInt(100) + 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
//            arr[i] = 1;
        }
    }

    private int c1 = 0;
    private int c2 = 0;
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        MultiThreadArraySum m = new MultiThreadArraySum();
        m.init();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < m.arr.length; i+=2) {
            m.c1 += m.arr[i];
        }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < m.arr.length; i+=2) {
                m.c2 += m.arr[i];
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(m.c1+m.c2);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
}
