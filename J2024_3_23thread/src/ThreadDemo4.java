public class ThreadDemo4 {
//    实现Runnable，重写run使用匿名内部类
    public static void main(String[] args) {
        Thread t = new Thread(new Thread() {
            @Override
            public void run() {
                System.out.println("hhh4");
            }
        });
        t.start();
    }
}
