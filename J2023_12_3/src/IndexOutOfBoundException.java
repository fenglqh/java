/**
 * 下标越界异常
 */
public class IndexOutOfBoundException extends RuntimeException{
    public IndexOutOfBoundException() {
    }

    public IndexOutOfBoundException(String message) {
        super(message);
    }
}
