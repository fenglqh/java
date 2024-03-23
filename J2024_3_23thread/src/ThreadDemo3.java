public class ThreadDemo3{

    //    继承Thread，重写run，使用匿名内部类

    public static void main(String[] args) {
        Thread  t = new Thread(new Thread() {
            @Override
            public void run() {
                System.out.println("hhh3");
            }
        });
        t.start();
    }
}
