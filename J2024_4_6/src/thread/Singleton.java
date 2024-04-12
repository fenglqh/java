package thread;

//public class Singleton {
//    public static Singleton instance = new Singleton();
//    private Singleton() {
//
//    }
//    public void run() {
//        System.out.println("hhhh");
//    }
//}
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {

    }
    public Singleton getInstance() {
        return instance;
    }
    public void run() {
        System.out.println("hhhh");
    }
}