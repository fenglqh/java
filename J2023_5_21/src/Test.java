public class Test {
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    //模9余0，不余0就整除
    public static int count(int a) {
        int ret = 0;
        if(a / 10 == 0) {
            if(a % 9 == 0) {
                return 1;
            } else {
                return 0;
            }
        }else {
            return count(a % 10) + count(a / 10);
        }
    }
    public static void main(String[] args) {
        int ret = 0;
//        for (int i = 1; i <= 10; i++) {
//            ret += count(i);
//        }
        System.out.println(count(10));//a%10 是0 所以 之后的a%9也是0
        System.out.println(ret);
    }
}
