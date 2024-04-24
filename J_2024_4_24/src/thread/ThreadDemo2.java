package thread;

import java.util.Timer;
import java.util.TimerTask;
class Test implements Runnable {
    @Override
    public void run() {
        System.out.println("Hhh");
    }
}
class Test02 {
//    private Test t = null;
    public Test02(ThreadDemo1 t) {
        t.run();
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
//        Test02 t = new Test02(()->{
//
//        });
//       Test02 t = new Test02(new Test() {
//           @Override
//           public void run() {
//               super.run();
//               System.out.println("hhh");
//           }
//       });
    }
    public static void main1(String[] args) {
        System.out.println("hhhhh");

//        ThreadDemo1 t = new ThreadDemo1();
//        t.getTimer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("hhh,1500");
//            }
//        },1500);
    }
}
