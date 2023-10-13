package user;

import book.BookList;
import operate.*;

import java.util.Scanner;

public class Normaluser extends User{

    public Normaluser(String name) {
        super(name);
        this.operates = new IOperate[] { new ExitOperation(),new FindOperation(), new BorrowOperation(), new ReturnOperation()};
    }

    public int menu() {
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void work(int choice, BookList bookList) {
        this.operates[choice].work(bookList);
    }
}
