package thread;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Point getPointByXY(double x, double y) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        return point;
    }
    public static Point getPointByRA(double r, double a) {
        Point point = new Point();
        point.setX(r * Math.cos(a));
        point.setY(r * Math.sin(a));
        return point;
    }

}
