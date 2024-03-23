public class ThreadDemo5 {
//    使用lambda表达式
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hhh5");
        });
        t.start();
    }
}
