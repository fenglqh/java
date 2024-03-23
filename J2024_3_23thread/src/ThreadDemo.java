class Thread1 extends Thread {
//    继承Thread类，重写run方法
    @Override
    public void run() {
        System.out.println("hhh1");
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
//        实质是传Thread的实例，必须得实现Thread接口和重写run方法
        Thread1 thread1 = new Thread1();
        Thread t = new Thread(thread1);
        t.start();
    }
}