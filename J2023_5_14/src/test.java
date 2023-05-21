public class test {
    public static void main(String[] args) {
        int b;
    }
    public static void main4(String[] args) {
        short a = 9999;
        short b = 8888;
        System.out.println(a+b);
    }
    public static void main3(String[] args) {
        int a = 309;
        System.out.println(a);
        int b = 'r';
        System.out.println(b);
    }


    public static void main2(String[] args) {
        byte a = 7;
//        System.out.println(a);
//        byte b = 127;
//        System.out.println(b);
//        byte c = 128;
        byte d = 'a';
        System.out.println("d = " + d);
//        byte e = '好';
    }
    public static void main1(String[] args) {
        //如果if的条件重合会怎么样
        int a = 20;
        if(a > 10) {
            System.out.println(a);
        } else if (a < 30) {
            System.out.println("aa");
        }
        //if条件不是一个世界的
        int b = 10;
        if(b < 20) {
            System.out.println(b);
        } else if (b % 10 == 0) {
            System.out.println("bb");
        }
        //if条件不是一个层次
        if( a > 10 ) {
            System.out.println("hh");
        } else if (b < 30) {
            System.out.println("ii");
        }
    }
}
