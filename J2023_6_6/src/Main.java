/**
 * 写博客的一些测试程序
 */
public class Main {
    public static void main(String[] args) {
        int a = 1;
        while (a < 9){
            System.out.println("a");
            a++;
            while (a < 3) {
                System.out.println("b");
                if(a == 2) {
                    break;
                }
            }

        }
    }
    public static char  func(){
        return '1';
    }
    public static void main1(String[] args) {
        int a = 1;
        char d = func();
        switch (d) {
            case 1:
                System.out.println("aaa");
                System.out.println("ccc");
                break;
            case 2:
                System.out.println("bbb");
               break;
            default:
                System.out.println("fff");
        }
    }
}