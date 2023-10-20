package user;

<<<<<<< HEAD
import book.BookList;
import operate.*;

=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
import java.util.Scanner;

public class Adminuser extends User {

    public Adminuser(String name) {
        super(name);
<<<<<<< HEAD
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

=======
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
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
