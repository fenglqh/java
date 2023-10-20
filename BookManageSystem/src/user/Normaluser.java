package user;

<<<<<<< HEAD
import book.BookList;
import operate.*;

=======
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
import java.util.Scanner;

public class Normaluser extends User{

    public Normaluser(String name) {
        super(name);
<<<<<<< HEAD
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
=======
    }

    public int menu() {
        System.out.printf("1.查找图书");
        System.out.printf("2.借阅图书");
        System.out.printf("3.归还图书");
        System.out.printf("0.退出系统");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
