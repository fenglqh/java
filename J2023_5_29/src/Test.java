public class Test {
    /**
     * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
     */
    public static int count(int num) {
        if(num / 10 == 0) {
            if(num % 10 == 9) {
                return 1;
            }else {
                return 0;
            }
        }else {
            return count(num / 10) + count(num % 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(count(19));
    }
}
