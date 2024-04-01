public class ThreadDemo3 {
    public static int a = 2;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("1" + Thread.currentThread().getState());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (a == 10) {
                System.out.println("2" + Thread.currentThread().getState());
                System.out.println("jjj");
            }
        });
        System.out.println("3" + t1.getState());
        t1.start();
        System.out.println("4" + t1.getState());
        while (a != 10) {
            a += 1;
        }
    }

    public static void main1(String[] args) {
        for (Thread.State state: Thread.State.values()
             ) {
            System.out.println(state);
        }
    }
}
