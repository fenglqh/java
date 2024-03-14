public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("jj");
        });
        t.start();
        System.out.println("hh");
    }
}
