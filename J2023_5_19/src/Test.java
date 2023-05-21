public class Test {
//    打印 1 - 100 之间所有的素数
//    编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static boolean is_prime(int a) {
        if ( a == 1 || a == 2 )  {
            return true;
        } else {
            int j = 0;
            for (j = 2; j < a; j++)
                if (a % j == 0) {
                    break;
                }
            if (j == a ) {
                return true;
            }else {
                return false;
            }
        }
    }
public static void main1(String[] args) {
    for (int i = 1; i < 101; i++) {
        if (is_prime(i)){
            System.out.println(i);
        }
    }
}
}
