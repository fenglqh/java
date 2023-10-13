package operate;

import book.BookList;

public class ExitOperation implements IOperate{
    @Override
    public void work(BookList bookList) {
        System.exit(0);
    }
}
