package exception;

public class PosError extends RuntimeException{
    public PosError() {

    }
    public PosError(String message) {
        super(message);
    }
}
