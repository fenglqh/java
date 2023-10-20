package operate;

<<<<<<< HEAD
import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要归还的书名:");
        String borrowName = sc.nextLine();

        int pos = bookList.getUsedSize();
        for (int i = 0; i < pos; i++) {
            Book book = bookList.getBooks(i);
            if(borrowName.equals(book.getName()) && book.getIsborrowed()) {
                book.setIsborrowed(false);
                System.out.println(book);
                System.out.println("您已成功归还图书！");
                return;
            }
        }
        System.out.println("书名写错了！");

    }
=======
public class ReturnOperation {
>>>>>>> 1057ee93a5e6272685f59534bfed6a77e5098a34
}
