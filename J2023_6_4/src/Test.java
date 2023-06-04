import java.util.Scanner;

public class Test {
//    创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
    public static int max2(int a, int b) {
        return a > b ? a : b;
    }
    public static int max3(int a, int b, int c) {
        return max2(max2(a, b), c);
    }
    public static void main(String[] args) {
        System.out.println(max3(2, 1, 4));
    }



//    输出n*n的乘法口诀表，n由用户输入。
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " x" + i + "= " + i*j + " ");
            }
            System.out.println();
        }
    }




//    编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = 3;
        while (flag != 0) {
            flag--;
            int a = sc.nextInt();
            if(a == 12345) {
                System.out.println("登录成功！");
                break;
            }else if(flag != 0) {
                System.out.println("您还有" + flag + "次机会输入密码" );
            }else {
                System.out.println("即将退出程序！");
            }
        }
    }


//    输出一个整数的每一位，如：123的每一位是3，2，1
    public static void main2(String[] args) {
        int a = 123;
        for (int i = 0; i < 3; i++) {
            System.out.print(a % 10 + " ");
            a = a / 10;
        }
    }




//  计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static void main1(String[] args) {
        double count = 0;
        int a = 1;
        for (int i = 1; i <= 100; i++) {
            count = count + (1.0/i) * a;
            if(a == 1) {
                a = -1;
            }else {
                a = 1;
            }
        }
        System.out.println(count);
    }
}
/**
 * 被类和对象搞得迷迷糊糊，县来波简单的循环结构放松一下吧
 */
//class Animal{
//    public int name;
//    public int age;
//    public void speak() {
//        System.out.println(this.name + "正在叫");
//    }
//
//    public int getName() {
//        return name;
//    }
//
//    public void setName(int name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//class a extends Animal{
//
//}
//class b extends Animal{
//
//}
//class c{
//
//}
//public class Test {
////    public static void main(String[] args) {
////        Animal a = new c();
//    }
//}
