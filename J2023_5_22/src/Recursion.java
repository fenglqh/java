import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
//    写一个递归方法，输入一个非负整数，返回组成它的数字之和
//    1234 = 1+2+3+4
    public static int add(int a) {
        if(a / 10 == 0) {
            return a;
        } else {
            return a%10 + add(a/10);
        }
    }


    public static void main(String[] args) {
        System.out.println(add(1234));
    }
    //    按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)    （递归）
//    123+4 12+3 1+2 1
    public static void print(int a) {
        if(a / 10 == 0) {
            System.out.print(a + " ");
        }else {
//            System.out.println(a % 10);
            print(a / 10);
            System.out.print(a % 10 + " ");

        }
    }

    public static void main3(String[] args) {
        print(1234);
    }
//    递归求 1 + 2 + 3 + ... + 10 n+(n-1)
    public static int sumFac(int n) {
        if ( n == 1) {
            return 1;
        }else {
            return n + sumFac(n - 1);
        }
    }

    public static void main2(String[] args) {
        System.out.println(sumFac(10));
    }

    //递归求 N 的阶乘
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }else {
            return n * fac(n - 1);
        }
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println(i + "的阶乘是" + fac(i));
    }
}
