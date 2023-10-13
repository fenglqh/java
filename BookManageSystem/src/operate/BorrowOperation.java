package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要借阅的书名:");
        String borrowName = sc.nextLine();

        int pos = bookList.getUsedSize();
        for (int i = 0; i < pos; i++) {
            Book book = bookList.getBooks(i);
            if(borrowName.equals(book.getName()) && !book.getIsborrowed()) {
                book.setIsborrowed(true);
                System.out.println(book);
                return;
            }
        }
        System.out.println("图书不存在或者已经被借走！");
    }
}
