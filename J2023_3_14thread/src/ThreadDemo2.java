class Myhread implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("hh");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r = new Myhread();
        Thread t = new Thread(r);
        t.start();
        while (true) {
            System.out.println("jj");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
