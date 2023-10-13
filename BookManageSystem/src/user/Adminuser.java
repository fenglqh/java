package user;

import book.BookList;
import operate.*;

import java.util.Scanner;

public class Adminuser extends User {

    public Adminuser(String name) {
        super(name);
        this.operates = new IOperate[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new ShowOperation()};
    }

    public int menu() {
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你的操作");
        int choice = sc.nextInt();
        return choice;
    }

    public void work(int choice, BookList bookList) {
        this.operates[choice].work(bookList);
    }

}
