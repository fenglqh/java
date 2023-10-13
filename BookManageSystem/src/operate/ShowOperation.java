package operate;

import book.BookList;

public class ShowOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        int pos = bookList.getUsedSize();
        for (int i = 0; i < pos; i++) {
            System.out.println(bookList.getBooks(i));
        }
    }

}
