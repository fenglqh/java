package thread;

public class SingletonLazy {
    private volatile static SingletonLazy instance = null;
    public Object locker = new Object();
    public SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (locker) {
                if (instance == null) instance = new SingletonLazy();
            }
        }
            return instance;
    }
    private SingletonLazy() {

    }
}
