/**
 * 单例模式，只允许创建一个实例
 */
//懒汉模式
class MySingLeton1{
//    通过把实例变成类属性的方式，来保证，只有一个实例
    private static MySingLeton1 instance = new MySingLeton1();
//    还需要限制住程序员new一个对象
    private MySingLeton1() {

    }
    //        提供一个方法给程序员获取唯一实例
    public static MySingLeton1 getInstance() {
        return instance;
    }
}
//饿汉模式
class MySingLeton2{
    // 引用指向唯一实例，这个实例先初始化，而不是立即创建
    private static MySingLeton2 instance = null;
    private MySingLeton2() {

    }
    public static MySingLeton2 getInstance() {
        if (instance == null) {
            instance = new MySingLeton2();
        }
        return instance;
    }
}
public class ThreadDemo8 {
    public static void main(String[] args) {
        MySingLeton2 m1 = MySingLeton2.getInstance();
        MySingLeton2 m2 = MySingLeton2.getInstance();
        System.out.println(m1 == m2);
    }
    public static void main1(String[] args) {
        MySingLeton1 m = MySingLeton1.getInstance();
        MySingLeton1 m1 = MySingLeton1.getInstance();
        System.out.println(m == m1);
    }
}
