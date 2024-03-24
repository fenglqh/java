class Thread1 extends Thread {
//    继承Thread类，重写run方法
    @Override
    public void run() {
        System.out.println("hhh1");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread1();
        t.start();
    }
}