public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("jj");
            }
        });
        t.start();
        System.out.println("hh");
    }
}
