import java.util.Scanner;

public class Main {
//    求2个整数的最大公约数
    public static int max_divisor(int a, int b) {
        int leave = a % b;
        while (leave != 0) {
            a = b;
            b = leave;
            leave = a % b;
        }
        return b;
    }
    //    求一个整数，在内存当中存储时，二进制1的个数。
    public static void main(String[] args) {
        System.out.println(max_divisor(21, 18));
    }
    public static int count(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int a = num >>> i;
            count += a & 1;
        }
        return count;
    }
    public static void main3(String[] args) {
        int a = -3;//1101
        System.out.println(count(a));
    }
        //给定一个数字，判定一个数字是否是素数
    public static boolean odd(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(odd(a));
    }
    //输出 1000 - 2000 之间所有的闰年
    public static boolean leap_year(int year) {
        if(year % 100 != 0 && year % 4 == 0) {
            return true;
        }else if (year % 400 == 0) {
            return true;//世纪闰年
        }else {
            return false;
        }
    }
    public static void main1(String[] args) {
        for (int i = 1000; i < 2001; i++) {
            if(leap_year(i)) {
                System.out.println(i);
            }
        }
    }
}