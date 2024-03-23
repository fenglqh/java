class Thread2 implements Runnable {
//实现Runnable，重写run
    @Override
    public void run() {
        System.out.println("hhh2");
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        Thread t = new Thread(thread2);
        t.start();
    }
}
