import java.util.Scanner;

public class Main {
    public static void login(String name, String pwd) throws PasswordException {
        if(!name.equals("aaaa")) {
            throw new PasswordException("(づ￣3￣)づ╭❤～,你的密码错误");
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String pwd = sc.nextLine();
        try{
            login(name,pwd);
        }catch (PasswordException e) {
            e.printStackTrace();
        }
    }
}
