package gof23.jintai;

public class CarFactory {
    public static Car getCar(String carType) {
        switch (carType) {
            case "兰博基尼":
                return new LBJN();
            case "法拉利":
                return new FaLaLi();
            default:
                return new LBJN();
        }
    }
}
