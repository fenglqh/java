package 牛客test;
//用到正则表达式
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isVaild {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String emailMatcher="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";

        //write your code here......
        //创建Pattern对象
        Pattern pattern = Pattern.compile(emailMatcher);
        //创建Matcher对象，并进行匹配
        Matcher matcher = pattern.matcher(str);
        //进行匹配
        if(matcher.find()) {
            //匹配成功的操作
            System.out.println("邮箱格式合法！");
        }else {
            System.out.println("邮箱格式不合法！");
        }

    }
}
