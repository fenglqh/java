package thread;

public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        BlookingQueue queue = new BlookingQueue();
        Thread t1 = new Thread(() -> {
            try {
                queue.put(1);
                queue.put(2);
                queue.put(3);
                queue.put(4);
                queue.put(5);
                queue.put(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        t2.start();
        System.out.println("--");
    }
}
