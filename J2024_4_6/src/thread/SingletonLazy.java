package thread;

public class SingletonLazy {
    private static SingletonLazy instance = null;
    public SingletonLazy getInstance() {
        if (instance == null) instance = new SingletonLazy();
        return instance;
    }
    private SingletonLazy() {

    }
}
