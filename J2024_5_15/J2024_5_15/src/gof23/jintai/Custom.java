package gof23.jintai;

public class Custom {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("兰博基尼");
        car1.name();
        Car car2 = CarFactory.getCar("法拉利");
        car2.name();
    }
}
