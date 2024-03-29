class Test01 implements Runnable{
    public void run() {

    };
//    public abstract void t();
}
public class ThreadDemo10 {
    public static void test(Test01 test01) {
        test01.run();
    }
    private static int a = 0;
    public static void main(String[] args) {
        test(new Test01() {
            public void run() {
                System.out.println(a);

            }
        });
        a++;

    }
}

