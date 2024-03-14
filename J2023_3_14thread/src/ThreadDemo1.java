import java.io.Serializable;
import java.lang.annotation.Annotation;

//第一种创建线程的方式
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("hh");
    }

}

public class ThreadDemo1{
    public static void main(String[] args) {
        //第一种方法
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("jj");
    }
}
