package operate;

import book.BookList;

public class ShowOperation implements IOperate{
    public void work(BookList bookList) {
        int usedsize = bookList.getUsedSize();
        for (int i = 0; i < usedsize; i++) {
            System.out.println(bookList.getBooks(i));
        }
    }

}
