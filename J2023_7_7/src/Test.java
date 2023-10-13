import java.util.Scanner;

/**
 * 期末荒废了太多，先进行简单的复习
 */
public class Test {
    //求斐波那契数列的第n项。(迭代实现)
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1 || n == 2) {
            System.out.println("斐波那契数列第" + n + "项是1");
        }else {
            int sum = 0;
            int a = 1;
            int b = 1;
            for (int i = 2; i < n; i++) {
                sum = a + b;
                a = b;
                b = sum;

            }
            System.out.println("斐波那契数列第" + n + "项是" + sum);
        }
    }
    //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static int sum(int a ,int b) {
        return a + b;
    }
    public static float sum(float a, float b, float c) {
        return a + b + c;
    }

    public static void main2(String[] args) {
        System.out.println(sum(2, 4));
        System.out.println(sum(1.2f, 1.3f, 2.2f));
    }
    //在同一个类中定义多个方法：要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
    public static int max(int a,int b) {
        return (a > b ? a : b);
    }
    public static float max(float a,float b,float c) {
        return ((a > b ? a : b) > c ? (a > b ? a : b) : c);
    }

    public static void main(String[] args) {
        System.out.println(max(3, 7));
        System.out.println(max(1.2f, 7.8f, 4.4f));
    }
}
