package thread;

import java.util.concurrent.*;

public class ThreadDemo4 {

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(6);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,1000
                ,TimeUnit.MILLISECONDS,blockingDeque);
        threadPoolExecutor.execute(() -> {
            System.out.println("hhh1");
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.submit(()->{
            System.out.println("hhh3");
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.submit(()->{
            System.out.println("hhh4");
            System.out.println(Thread.currentThread().getName());
        });
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh2");
            System.out.println(Thread.currentThread().getName());
        });








    }
    public static void main1(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> System.out.println("3000"),3000,TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> System.out.println("1000"),1000,TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(() -> System.out.println("2000"),2000,TimeUnit.MILLISECONDS);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hhh1");
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        executorService.execute(() -> {
//            System.out.println("hhh2");
//            System.out.println(Thread.currentThread().getName());
//        });
//        executorService.submit(() -> {
//            System.out.println("hhh3");
//            System.out.println(Thread.currentThread().getName());
//        });
//        executorService.submit(() -> {
//            System.out.println("hhh4");
//            System.out.println(Thread.currentThread().getName());
//        });
//        executorService.submit(() -> {
//            System.out.println("hhh5");
//            System.out.println(Thread.currentThread().getName());
//        });
//        Future<?> hhh6 = executorService.submit(() -> {
//            System.out.println("hhh6");
//            System.out.println(Thread.currentThread().getName());
//        });
//        executorService.submit(() -> {
//            System.out.println("hhh7");
//            System.out.println(Thread.currentThread().getName());
//        });
//        executorService.submit(() -> {
//            System.out.println("hhh8");
//            System.out.println(Thread.currentThread().getName());
//        });
//        System.out.println(hhh6.isDone());
//        System.out.println(hhh6.isDone());
//        System.out.println(hhh6.isDone());
    }
}
