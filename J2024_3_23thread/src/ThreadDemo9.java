/**
 * 单例模式
 */
//饿汉模式
class SingLeton{
    //类唯一的对象
    private static SingLeton instance = new SingLeton();
    //通过构造方法的限制，让编译器帮助检测只能创建一个对象
    private SingLeton() {}
    //提供一个方法，外部类可以得到这个对象
    public static SingLeton getInstance() {
        return instance;
    }
    //其他方法，类的别的操作
    public void work() {
        System.out.println("hhh");
    }

}
//懒汉模式
class SingLetonLazzy{
    //类属性指向唯一实例的引用
    private static SingLetonLazzy instance = null;
    private SingLetonLazzy() {}
    //访问唯一实例的方法
    public static SingLetonLazzy getInstance() {
        //让实例在第一次调用方法的时候才创建
        if (instance == null) {
            instance = new SingLetonLazzy();
        }
        return instance;
    }
    public void work() {
        System.out.println("xxx");
    }
}

/**
 * 阻塞队列
 */
class MyArrayBlookingQueue {
    //数组存放队列元素
    private int[] elems = null;
    //构造方法初始化数组容量
    public MyArrayBlookingQueue() {
        elems = new int[6];
    }
    public MyArrayBlookingQueue(int n) {
        elems = new int[n];
    }
    //队列头
    private int head = 0;
    //队列尾
    private int tail = 0;
    //队列长度
    private int size = 0;

    //入队列
    public void offer(int data) {

    }
}
public class ThreadDemo9 {
    public static void main(String[] args) {
//        SingLetonLazzy s = new SingLetonLazzy();
        SingLetonLazzy s = SingLetonLazzy.getInstance();
        s.work();
        SingLetonLazzy s1 = SingLetonLazzy.getInstance();
        System.out.println(s == s1);
    }
    public static void main1(String[] args) {
//        SingLeton s = new SingLeton();  外部类直接访问，编译器会直接报错，只能通过指定方法得到对象
        SingLeton s = SingLeton.getInstance();
        s.work();
        SingLeton s1 = SingLeton.getInstance();
        System.out.println(s1 == s);
    }
}
