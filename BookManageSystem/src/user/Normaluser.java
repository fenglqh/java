package user;

import java.util.Scanner;

public class Normaluser extends User{

    public Normaluser(String name) {
        super(name);
    }

    public int menu() {
        System.out.printf("1.查找图书");
        System.out.printf("2.借阅图书");
        System.out.printf("3.归还图书");
        System.out.printf("0.退出系统");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
