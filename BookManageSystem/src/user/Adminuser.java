package user;

import java.util.Scanner;

public class Adminuser extends User {

    public Adminuser(String name) {
        super(name);
    }
    public int menu() {
        System.out.printf("1.查找图书");
        System.out.printf("2.新增图书");
        System.out.printf("3.删除图书");
        System.out.printf("4.显示图书");
        System.out.printf("0.退出系统");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
