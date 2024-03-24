class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("hhh2");
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable = new Thread2();
        Thread t = new Thread(runnable);
        t.start();
    }
}
