public class Pack {
    /*
    基本数据类型变成引用数据类型是装箱，引用数据类型变成基本数据类型则是拆箱。
     */

    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;

        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }
    public static void main2(String[] args) {
        //拆箱
        Integer a = 100;
        int val = a;//自动拆箱
        System.out.println(val);
        /*
        然后可以进行反汇编，会发现底层调用了Integer.intValue()方法
         */
        int val2 = a.intValue();
        System.out.println(val2);
    }


    public static void main1(String[] args) {
        //装箱
        int a = 100;
        Integer b = a;
        Integer c = 100; //自动装箱
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Integer d = new Integer(a);//隐式装箱
        /*
         private final int value;
         public Integer(int value) {
        this.value = value;
        所以这个的的意思是直接给Integer这个类中的value直接赋值，赋值完之后，value就不能修改了
    }
         */
        Integer e = Integer.valueOf(a);
        /*
         public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);


         static final int low = -128;
        static final int high;

    }

         */
        System.out.println(d);
        System.out.println(e);


    }
}
