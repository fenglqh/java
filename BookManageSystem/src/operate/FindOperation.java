package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入查找图书的名字:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if(name.equals(book.getName())) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("不存在该图书！");
    }
}
