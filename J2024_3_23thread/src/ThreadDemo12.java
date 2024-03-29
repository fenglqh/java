import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
interface Test12 extends Runnable, Future {
//接口的实现类用implements，但是接口之间的继承扩展功能用extends
}
public class ThreadDemo12 {
    public static void main(String[] args) {
        Callable<Integer> a = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(a);
    }
}
