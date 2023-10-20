package operate;

<<<<<<< HEAD
import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新增图书的名字:");
        String name = sc.nextLine();
        System.out.println("请输入新增图书的作者:");
        String author = sc.nextLine();
        System.out.println("请输入新增图书的类型:");
        String type = sc.nextLine();
        System.out.println("请输入新增图书的价格:");
        int price = sc.nextInt();


        int nowpos = bookList.getUsedSize();
//        Book book = bookList.getBooks(nowpos);
//        book = new Book(name,author,price,type);
//
//        System.out.println(book);
        bookList.setBooks(nowpos, name, author, price, type);
        bookList.setUsedSize(nowpos+1);
    }

=======
import book.BookList;

public class AddOperation implements IOperate{
    public void work(BookList bookList) {
        System.out.println("增加");
    }
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
