public class Test {
    public static void main(String[] args) {
        short b = Short.valueOf("3456");
        System.out.println(b);
    }
    /**
     * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
     */
    public static int count (int n) {
        if(n / 10 == 0) {
            if(n == 9) {
                return 1;
            }else {
                return 0;
            }
        }else {
            return count(n % 10) + count(n / 10);
        }
    }
    public static void main1(String[] args) {
        int ret = 0;
        for (int i = 1; i < 20; i++) {
            ret = ret + count(i);
        }
        System.out.println(ret);
    }
}
