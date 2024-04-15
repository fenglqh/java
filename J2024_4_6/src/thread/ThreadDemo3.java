package thread;

public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        MyBlookingQueue queue = new MyBlookingQueue();
        Thread t1 = new Thread(() -> {
            try {
                queue.put("a");
                queue.put("b");
                queue.put("c");
                queue.put("d");
                queue.put("e");
                queue.put("f");
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
