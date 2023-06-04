class Test1{
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}


public class Test {
    public static void main(String[] args) {
//        int a = 9;
//        System.out.println(!a);
//        boolean b = false;
//        System.out.println(!b);
//        int c = 8;
//        System.out.println(a && c);
//        boolean d = true;
//        System.out.println((a == c) && (1 / 0 == 0));
//        System.out.println((4 < 3) || (1 / 0 == 0));//报错：Exception in thread "main" java.lang.ArithmeticException: / by zero
//        System.out.println((4 > 3) || (1 / 0 == 0)); // 编译成功结果为true
        int a = 5;
        int b = -3;
        System.out.println(a & b);
    }
    public static void main3(String[] args) {
        short a = 9;
        short b = 0;
        b = a++; // a = 10
        System.out.println(b);
        b = ++a; // a = 11
        System.out.println(b);
    }
    public static void main2(String[] args) {
        System.out.println(5 % 2);//1
        System.out.println(-5 % 2);//-1
        System.out.println(5 % -2);//1
        System.out.println(-5 % -2);//-1
    }
    public static void main1(String[] args) {
        Test1 test = new Test1();
        System.out.println(test);
    }
}
