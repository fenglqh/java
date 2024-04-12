package thread;

public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        BlookingQueue queue = new BlookingQueue();
        Thread t1 = new Thread(() -> {
            try {
                queue.offer(1);
                queue.offer(2);
                queue.offer(3);
                queue.offer(4);
                queue.offer(5);
                queue.offer(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();
        t2.start();
        System.out.println("--");
    }
}
